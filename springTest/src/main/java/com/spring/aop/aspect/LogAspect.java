package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Created by ThinkPad on 2016/11/29.
 */
@Component
@Aspect
public class LogAspect {
    //配置切入点,该方法无方法体,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.spring.aop.service..*(..))")
    public void aspect(){	}

    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        System.out.println(joinPoint+"方法执行前...."+joinPoint.getArgs());
    }

    //配置后置通知,使用在方法aspect()上注册的切入点
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        System.out.println(joinPoint+"方法执行后...."+joinPoint.getArgs());
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning("aspect()")
    public void afterReturn(JoinPoint joinPoint){
        System.out.println(joinPoint+"方法执行返回后...."+joinPoint.getArgs());
    }
}
