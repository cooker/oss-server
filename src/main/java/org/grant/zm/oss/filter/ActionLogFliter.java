package org.grant.zm.oss.filter;

import org.apache.commons.io.IOUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;

/**
 * grant
 * 16/3/2020 5:14 下午
 * 描述：
 */
@Aspect
@Component
public class ActionLogFliter {

    @Pointcut("@annotation(io.swagger.annotations.ApiOperation)")
    public void log(){

    }

    @Before("log()")
    public void printLog(JoinPoint joinPoint){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            Enumeration<String> headerNames = request.getHeaderNames();
            Enumeration<String> parameterNames = request.getParameterNames();
            String key = null, val = null;
            try {
                Field field = ReflectionUtils.findField(joinPoint.getTarget().getClass(), "log", Logger.class);
                field.setAccessible(true);
                Logger log = (Logger) ReflectionUtils.getField(field, joinPoint.getTarget());
                log.info("{} >> {}", request.getMethod(), request.getRequestURI());
                log.info("header ======================== ");
                while (headerNames.hasMoreElements()){
                    key = headerNames.nextElement();
                    val = request.getHeader(key);
                    log.info("{} => {}", key, val);
                }
                log.debug("params ======================== ");
                while (parameterNames.hasMoreElements()) {
                    key = parameterNames.nextElement();
                    val = request.getParameter(key);
                    log.info("{} => {}", key, val);
                }
                log.info("body ======================== ");
                String body = IOUtils.toString(request.getInputStream(), "utf-8");
                log.info("{}", body);
            } catch ( IOException e) {
                e.printStackTrace();
            }
        }
    }
}
