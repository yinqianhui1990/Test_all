package com.spring.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by ThinkPad on 2016/11/29.
 */
@Component
@Aspect
public class LogAspect {
    //配置切入点,该方法无方法体,可随意命名,主要为方便同类中其他方法使用此处配置的切入点
    @Pointcut("execution(* com.spring.aop.service..*(..))")
    public void aspect(){	}

    //切入点配置成上面命名好的切入点
    @Before("aspect()")
    public void before(JoinPoint joinPoint){
        Object[] agrs=joinPoint.getArgs();
        System.out.println(joinPoint+"方法执行前...."+agrs);
        if(agrs!=null){
            System.out.println("参数为："+Arrays.toString(agrs));
        }
    }

    //配置后置通知,使用在方法aspect()上注册的切入点
    @After("aspect()")
    public void after(JoinPoint joinPoint){
        System.out.println(joinPoint+"方法执行后...."+joinPoint.getArgs());
    }

    //配置后置返回通知,使用在方法aspect()上注册的切入点
    @AfterReturning(pointcut="aspect()", returning="returnValue")
    public void afterReturn(JoinPoint joinPoint, Object returnValue){
       // System.out.println(joinPoint+"方法执行返回后...."+joinPoint.getArgs());
        System.out.println(joinPoint+"方法执行返回值为："+returnValue);
    }
}
