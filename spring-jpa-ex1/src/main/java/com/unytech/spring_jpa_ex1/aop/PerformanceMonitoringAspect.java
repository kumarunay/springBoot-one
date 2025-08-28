package com.unytech.spring_jpa_ex1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitoringAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceMonitoringAspect.class);
    @Around("execution(* com.unytech.spring_jpa_ex1.service.ProductService.*(..))")
    public Object monitoringtime(ProceedingJoinPoint jp) throws Throwable {

        long start = System.currentTimeMillis();

        Object ob = jp.proceed();

        long end = System.currentTimeMillis();

        LOGGER.info("Time Taken :" + jp.getSignature().getName() + " : "+ (end-start)+" ms" );

        return ob;
    }
}
