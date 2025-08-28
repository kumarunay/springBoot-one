package com.unytech.spring_jpa_ex1.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    @Before("execution(* com.unytech.spring_jpa_ex1.service.ProductService.getProductById(..)) || execution(* com.unytech.spring_jpa_ex1.service.ProductService.addOrUpdateProduct(..))")
    public void logMethodCalled(JoinPoint jp){
        LOGGER.info("Log Method called "+ jp.getSignature().getName());
    }

    @After("execution(* com.unytech.spring_jpa_ex1.service.ProductService.getProductById(..)) || execution(* com.unytech.spring_jpa_ex1.service.ProductService.addOrUpdateProduct(..))")
    public void logMethodExecuted(JoinPoint jp){
        LOGGER.info("Log Method Executed "+ jp.getSignature().getName());
    }
    @AfterReturning("execution(* com.unytech.spring_jpa_ex1.service.ProductService.getProductById(..)) || execution(* com.unytech.spring_jpa_ex1.service.ProductService.addOrUpdateProduct(..))")
    public void logMethodAfterExecution(JoinPoint jp){
        LOGGER.info("Log Method called "+ jp.getSignature().getName());
    }

    @AfterThrowing("execution(* com.unytech.spring_jpa_ex1.service.ProductService.getProductById(..)) || execution(* com.unytech.spring_jpa_ex1.service.ProductService.addOrUpdateProduct(..))")
    public void logMethodException(JoinPoint jp){
        LOGGER.info("Log Method called "+ jp.getSignature().getName());
    }
}
