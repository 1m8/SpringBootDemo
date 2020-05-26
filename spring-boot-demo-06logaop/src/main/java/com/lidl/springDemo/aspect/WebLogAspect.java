package com.lidl.springDemo.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("execution(public * com.lidl.springDemo.controller.*Controller.*(..))")
    public void log(){

    }

    @Before("log()")
    public void beforeLog()
    {
        log.info("BeforeLog");
    }

    @After("log()")
    public void afterLog(){
        log.info("After");
    }

    @Around("log()")
    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
        log.info("Around 执行之前");
        Object result = point.proceed();
        log.info("【返回值】：{}", result);
        return result;
    }






}
