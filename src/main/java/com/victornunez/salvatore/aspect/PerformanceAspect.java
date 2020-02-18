package com.victornunez.salvatore.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(PerformanceAspect.class);

    @Around("@annotation(Performance)")
    public Object performance(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        LOGGER.info(String.format("%s executed in %s ms", joinPoint.getSignature(), executionTime));
        return proceed;
    }

}