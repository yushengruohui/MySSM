package com.yusheng.aspects;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//测试完毕
//@Aspect
//@Component
public class TimeCountAspect {


    @Before("execution(* com.yusheng.service..*.*(..))")
    public void beforeDome(JoinPoint joinPoint) {

        System.out.println("===== before =====");
        String methodName = joinPoint.getSignature().getName();
        String simpleName = joinPoint.getSignature().getDeclaringType().getSimpleName();
        System.out.println("在方法 " + simpleName + "的" + methodName + "前执行：");
        System.out.println("===== before =====");

    }

    @Around("execution(* com.yusheng.service..*.*(..))")
    public void aroundDome(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println("===== Around =====");

        //控制进程是否继续
        joinPoint.proceed();

        System.out.println("===== Around =====");

    }

    @After("execution(* com.yusheng.service..*.*(..))")
    public void afterDome(JoinPoint joinPoint) {

        System.out.println("===== after =====");
        String methodName = joinPoint.getSignature().getName();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("在方法 " + declaringTypeName + "的" + methodName + "后执行：");
        System.out.println("===== after =====");

    }

    @AfterReturning(returning = "returnvalue",pointcut = "execution(* com.yusheng.service..*.*(..))")
    public void afterReturningDome(JoinPoint joinPoint,Object returnvalue) {

        System.out.println("===== AfterReturning =====");
        String methodName = joinPoint.getSignature().getName();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println("在方法 " + declaringTypeName + "的" + methodName + "执行后返回值为："+returnvalue);
        System.out.println("===== AfterReturning =====");

    }
}
