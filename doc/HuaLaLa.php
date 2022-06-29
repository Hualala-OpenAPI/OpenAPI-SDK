<?php
/**
 * Class Plugin_HuaLaLa
 */
class Plugin_HuaLaLa{
    
    //系统参数，需要开发者维护
	private $base_url = 'https://www-openapi.hualala.com';  //正式环境
    private $app_key = null;  //开发者appKey(http://open.web.hualala.com/ 实名认证后个人中心获取)
    private $app_secret = 'null';  //开发者appSecret
    private $group_id = null; //集团ID
	private $version = "2.0"; //版本号，固定传2.0
    private $signature_params = array();//签名时，多维数组转化为一位数组


    /**
     * 签名将方法
	 * 所有公共参数及业务参数（其中signature，requestBody以及为空的参数除外）按照参数名的字典顺序排序(忽略大小写)
     * @return array $params 所有公共参数及业务参数
     * @return string
     */
    private function get_signature($params = array())
    {
        $params = $this->make_one_array($params);
        $upper_params = $sort_params = array();
        foreach($params as $key=>$val){
            $upper_params[strtoupper($key)] = $val;
        }

        ksort($upper_params);
        reset($upper_params);
        foreach ($upper_params as $k => $v) {
            foreach ($params as $k1 => $v1) {
                if (strtoupper($k1) == $k) {
                    $sort_params[$k1] = $v;
                }
            }
        }

        $params_string  = 'key';
        foreach($sort_params as $key => $value){
            $params_string .= $key.$value;
        }
		
		$params_string = $params_string.'secret';
		echo "签名加密前字符串：".$params_string;
		echo  "</br>";
        return strtoupper(sha1($params_string));
		
    }

    /**
     * @param array $data 接口参数
     * @return array
     */
    private function make_one_array($data,$flag = true)
    {
        if($flag){
            $this->signature_params = array();
            $flag = false;
        }

        foreach($data as $key => $val){
            if(is_array($val)){
                $this->make_one_array($val,$flag);
            }else{
                $this->signature_params[$key] = $val;
            }
        }
        return $this->signature_params;
    }



    /**
     * 业务参数加密规则,用AES算法加密，秘钥为开发者秘钥，偏移量为开发者秘钥，加密模式：CBC,填充模式；NoPadding
	 * AES-128-CBC 加密
     * @param array $businessParams 业务参数
     * @return string
     */
    public function encryptAES($businessParams){
		if (strlen($this->app_secret) == 8){
			$key =  $this->app_secret.$this->app_secret;
			$iv = $this->app_secret.$this->app_secret;
		}
		elseif (strlen($this->app_secret) == 16){
			$key =  $this->app_secret;
			$iv = $this->app_secret;
		}
		

        if (strlen($businessParams) % 16) {
            $businessParams = str_pad($businessParams,strlen($businessParams) + 16 - strlen($businessParams) % 16, "\0");
        }
        $result = openssl_encrypt($businessParams, 'AES-128-CBC',$key, OPENSSL_NO_PADDING, $iv);
        return base64_encode($result);
    }
	
	
	/**
     * AES-128-CBC 解密
     */
	public function dncrypt($requestBody){
		$key = $iv = $this->app_secret;
        $data = str_replace('\n','',$requestBody);
        $r = openssl_decrypt(base64_decode($data), "AES-128-CBC", $key, OPENSSL_NO_PADDING, $iv);
		return($r);
    }


    /**
     * 获取当前的毫秒时间戳
     * @return float
     */
    public function get_msectime()
    {
        list($msec, $sec) = explode(' ', microtime());
        $msectime = (float)sprintf('%.0f', (floatval($msec) + floatval($sec)) * 1000);
        return $msectime;
    }
	
	/**
     *  traceID 唯一字符串（UUID）
     */
    public function getTraceID(){
        $str = uniqid(mt_rand(),1);
        return md5($str);
    }

    /**
     * 调用接口方法
     * @param string $url 请求接口url
     * @param array $params 业务参数
     * @param string $method 请求方法，默认post请求
     * @return mixed
     */
    public function call($url, $params = array(), $method = 'post'){
        $ch = curl_init();
        $url = $this->base_url.$url;

        $request_param = array(
            'appKey' => $this->app_key,
			'appSecret' => $this->app_secret,
            'timestamp' => $this->get_msectime(),
            'version' => $this->version,
        );

        $request_param['signature'] = $this->get_signature(array_merge($params,$request_param));
        $request_param['requestBody'] = $this->encryptAES(json_encode($params));
		
		
		//请求的HTTP头域中包含以下字段
        //traceID 唯一字符串（UUID） -- 自定义即可
        $headers = [
            "Content-Type: application/x-www-form-urlencoded",
            "groupID:".$this->group_id,
            "traceID:".$this->getTraceID()
        ];
		
		curl_setopt($ch, CURLOPT_URL, $url);
        curl_setopt($ch,CURLOPT_HTTP_VERSION,CURL_HTTP_VERSION_1_1);
        curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false);
        curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, false);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
        curl_setopt($ch, CURLOPT_USERAGENT, $_SERVER['HTTP_USER_AGENT']);
        curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true);
        curl_setopt($ch, CURLOPT_AUTOREFERER, true);
        if($method == 'post')
		{
			curl_setopt($ch, CURLOPT_POST, true);
            if ($request_param != '')
            {
                curl_setopt($ch, CURLOPT_POSTFIELDS, http_build_query($request_param));
            }
        }
		

        $result = curl_exec($ch);
        $response = json_decode($result, true);
		
		//请求出错
        if(curl_errno($ch)){
            $this->error_code = 'CURL ERROR:'.curl_errno($ch);
            $this->error_message = curl_error($ch);
        }

        //接口没有响应
        if(is_null($response)){
            $this->error_code = 'INVALID RESPONSE';
            $this->error_message = '接口没有任何响应';
        }
		
        return $response;
		
    }
	
	
    /**
     * 获取集团下的店铺列表信息
     *
     * @param string $merchantsName 商户名
     * @return array
     */
    public function get_shops()
    {
		// 接口业务参数，需要开发者维护
        $data = array(
            'groupID' => $this->group_id
        );
        return $this->call('/doc/getAllShop', $data);
    }


}

$get_shop = new Plugin_HuaLaLa;
$res = $get_shop->get_shops();
echo $res;

?>