# 描述

> 此项目主要解决请求签名的问题, 不是完善的SDK. 我们接受高质量的pr, 你可以帮我们完善此项目.

# 环境

> JDK: 1.8及以上 需要支持lambda特性

# 结构

> sdk模块包含主要的逻辑代码, 相关封装都在这里. 通过intf目录下的接口文件定义行为, 实现具体逻辑后供调用. 
> 
> demo模块为sdk中相关接口的测试调用样例.
> 
> server-demo模块为sdk的具体接口包装. 成功启动服务后, 配合 [前端demo](https://github.com/Hualala-OpenAPI/OpenAPI-SDK-Sample) 做演示用

# 脚本

```
工作目录切换到sdk目录下, 执行
mvn install # 安装依赖包到本地
mvn deploay # 部署依赖包到您的私服
``` 

# 使用

> 部署好的依赖包, 您可以像普通的第三方依赖一样使用它
> 需要配置如下环境变量,启动类设置对应环境的appKey,appSecret

```
    public static final String ENV_KEY = "hll.openapi.env";                 //环境现在固定为 ONLINE
    public static final String APP_KEY_KEY = "hll.openapi.appKey";          //申请到的哗啦啦开放平台appKey
    public static final String APP_SECRET_KEY = "hll.openapi.appSecret";    //申请到的哗啦啦开放平台appSecret
```