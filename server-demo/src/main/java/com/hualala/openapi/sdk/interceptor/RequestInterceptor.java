package com.hualala.openapi.sdk.interceptor;

import com.alibaba.fastjson.JSON;
import com.hualala.openapi.sdk.beans.response.ResultBean;
import com.hualala.openapi.sdk.consts.ConstantsEnum;
import com.hualala.openapi.sdk.utils.CacheUrlUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class RequestInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(RequestInterceptor.class);
    @Autowired
    private CacheUrlUtil cacheUrl;

    /**
     * 定义拦截规则；拦截com.hualala.openapi.controller包下的所有类中，有@RequestMapping注解的方法
     */
    @Pointcut("execution(* com.hualala.openapi.sdk.controller..*(..)) && @annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void controllerMethodPointcut() {
    }

    /**
     * 拦截器具体实现
     *
     * @return JsonResult（被拦截方法的执行结果，或需要登录的错误提示。）
     */
    @Around("controllerMethodPointcut()") // 指定拦截器规则
    public Object Interceptor(ProceedingJoinPoint pjp) {
        logger.info("ControllerInterceptor controllerMethodPointcut start");
        try {
            ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = sra.getRequest();
            String url = request.getRequestURI();
            // 进行路由判断该接口是否存在，若存在则放行，否则拦截
            if (cacheUrl.isExistUrl(url)) {
                // 一切正常的情况下，继续执行被拦截的方法
                return pjp.proceed();
            } else {
                // 返回结果集
                ResultBean resultBean = new ResultBean(
                    ConstantsEnum.INSUFFICIENT_PERMISSIONS.getValue() + "",
                    ConstantsEnum.INSUFFICIENT_PERMISSIONS.getReasonPhrase());
                logger.warn("ControllerInterceptor controllerMethodPointcut get permission fail");
                return JSON.toJSONString(resultBean);
            }
        } catch (Throwable e) {
            logger.error("RequestInterceptor error", e);
            ResultBean resultBean = new ResultBean(
                ConstantsEnum.SERVICE_TEMPORARILY_UNAVAILABLE.getValue() + "",
                ConstantsEnum.SERVICE_TEMPORARILY_UNAVAILABLE.getReasonPhrase());
            return JSON.toJSONString(resultBean);

        }
    }
}

