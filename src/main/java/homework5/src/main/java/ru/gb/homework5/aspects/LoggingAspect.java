package ru.gb.homework5.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @After(value = "@annotation(ru.gb.homework5.aspects.TrackUserAction)")
    public void log(JoinPoint joinPoint) {
        logger.info("Method " + joinPoint.getSignature().getName() + " executed");
    }
}
