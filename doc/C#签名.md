# 说明
> 以下是来自C#技术栈的开发者提供的C#签名和加密的代码, 供大家参考


```aidl
        /// <summary>

        /// signature  签名计算结果；生成秘钥串

        /// </summary>

        /// <param name="dicPublic"></param>

        /// <param name="dicBusiness"></param>

        /// <param name="devPwd"></param>

        /// <param name="logMsg"></param>

        /// <returns></returns>

        public string GetSign(IDictionary<string, object> dicPublic, IDictionary<string, object> dicBusiness,

            string devPwd)

        {

            var dic = dicPublic;

            foreach (var item in dicBusiness)

            {

                //排除泛型

                if (!item.Value.GetType().IsGenericType)

                {

                   // if(item.Value.GetType().i)

                    dic.Add(item);

                }

            }

            dic.Add("appSecret", devPwd);

            //logMsg = $"生成签名 所有参数:{dic.ToJson()}\r\n";

            var sortStr = dic.DicToQueryString(true, "signature,requestBody");

            var bforeEncryption = "key" + sortStr + "secret";

            //logMsg += $"\r\n加密前签名:{bforeEncryption}\r\n";

            var signature = SHA1Helper.SHA1Encrypt(bforeEncryption);

            //logMsg += $"\r\n签名结果:{signature}";

            dic.Remove("devPwd");

            return signature.ToUpper();

        }



        /// <summary>

        /// AES加密（requestBody业务参数加密方法）

        /// </summary>

        /// <param name="text">明文字符串</param>

        /// <param name="key">秘钥</param>

        /// <param name="iv">加密辅助向量</param>

        /// <returns>密文</returns>

        public static string AESEncrypt(string text, string key, string iv)

        {

            RijndaelManaged rijndaelCipher = new RijndaelManaged();

            rijndaelCipher.Mode = CipherMode.CBC;

            rijndaelCipher.Padding = PaddingMode.Zeros;

            rijndaelCipher.KeySize = 128;

            rijndaelCipher.BlockSize = 128;

            byte[] pwdBytes = System.Text.Encoding.UTF8.GetBytes(key);

            byte[] keyBytes = new byte[16];

            int len = pwdBytes.Length;

            if (len > keyBytes.Length) len = keyBytes.Length;

            System.Array.Copy(pwdBytes, keyBytes, len);

            rijndaelCipher.Key = keyBytes;

            byte[] ivBytes = System.Text.Encoding.UTF8.GetBytes(iv);

            rijndaelCipher.IV = ivBytes;

            ICryptoTransform transform = rijndaelCipher.CreateEncryptor();

            byte[] plainText = Encoding.UTF8.GetBytes(text);

            byte[] cipherBytes = transform.TransformFinalBlock(plainText, 0, plainText.Length);

            return Convert.ToBase64String(cipherBytes);

        }
        
        /// <summary>
        /// dictionary转为querystring
        /// </summary>
        /// 
        /// <param name="dic">参数dictionary</param>
        /// <param name="isSort">是否排序</param>
        /// <param name="excludeKey">排除Key</param>
        /// <returns>querystring</returns>
        public static string DicToQueryString(this IDictionary<string, object> dic, bool isSort, string excludeKey = null)
        {
            var dicTmp = new Dictionary<string, string>();
            
            foreach (KeyValuePair<string, object> k in dic)
            {
                string key = k.Key;
                object value = k.Value;
                if (!string.IsNullOrEmpty(excludeKey) && excludeKey.Contains(key))
                {
                    continue;
                }
                GetKeyValue(key, value, ref dicTmp);
            
            }
            if (isSort)
            {
                dicTmp = dicTmp.OrderBy(o => o.Key).ToDictionary(o => o.Key, p => p.Value);
            }
            StringBuilder sb = new StringBuilder();
            foreach (var item in dicTmp)
            {
                if (!string.IsNullOrEmpty(excludeKey) && excludeKey.Contains(item.Key))
                {
                    continue;
                }
                sb.Append(item.Key + item.Value);
            }
            var result = sb.ToString();
            return result;
            #region
            #endregion
        }

        public static void GetKeyValue(string key, object obj, ref Dictionary<string, string> dic)
        {
            var type = obj.GetType();
            if (obj == null || (obj is string && string.IsNullOrEmpty(obj.ToString())))
            {
                return;
            }
            if (type.IsValueType || obj is string)
            {
                if (!dic.Keys.Contains(key))
                {
                    dic.Add(key, type.IsValueType? obj.ToString().ToLower(): obj.ToString());
                }
            }
            else //引用类型
            {
                var typeArr = type.GetProperties();
                foreach (var propertyInfo in typeArr)
                {
                    object value = propertyInfo.GetValue(obj, null);
                    if (value == null)
                    {
                        continue;
                    }
                    if (value.GetType().IsValueType)
                    {
                        GetKeyValue(propertyInfo.Name, value, ref dic);
                    }
                    //当该属性为List泛型时，或者为数组时。
                    else if (propertyInfo.PropertyType.IsGenericType || propertyInfo.PropertyType.IsArray)
                    {
                        Type objType = value.GetType();//value为集合
                        int count = Convert.ToInt32(objType.GetProperty("Count").GetValue(value, null));
                        for (int i = 0; i < count; i++)
                        {
                            //如果是集合
                            object item = objType.GetProperty("Item").GetValue(value, new object[] { i });
                            GetKeyValue(propertyInfo.Name, item, ref dic);
                            break;//运行一次，只取第一个元素参与签名验证
                        }
                    }
                    //属性为引用类型
                    else if (propertyInfo.PropertyType.IsClass)
                    {
                        GetKeyValue(propertyInfo.Name, value, ref dic);
                    }
                }
            }
        }
        
        /// <summary>
        /// SHA1 加密（不可逆加密）
        /// </summary>
        /// <param name="pass">要加密的原始字串</param>
        /// <returns></returns> 
        public static string SHA1Encrypt(string pass)
        {
            System.Security.Cryptography.SHA1 sha1 = new System.Security.Cryptography.SHA1CryptoServiceProvider();
            byte[] bytResult = sha1.ComputeHash(System.Text.Encoding.UTF8.GetBytes(pass));
            sha1.Clear();
            string strResult = BitConverter.ToString(bytResult);
            strResult = strResult.Replace("-", "");
            return strResult;
            /* 另一种方法
           pass = FormsAuthentication.HashPasswordForStoringInConfigFile(pass, "SHA1");
            return pass;
            */
        }
```