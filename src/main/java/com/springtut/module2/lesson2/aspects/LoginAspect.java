package com.springtut.module2.lesson2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoginAspect {
    private Logger logger = Logger.getLogger(getClass().getName());
    @Before("execution(void com.springtut.module2.lesson2..*.set*(*))")
    public void callSetters(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().getName();
        String arg = joinPoint.getArgs()[0].toString();
        logger.info("Called " + method + " with arg " + arg
                +  " on " + joinPoint.getTarget());
    }
}
