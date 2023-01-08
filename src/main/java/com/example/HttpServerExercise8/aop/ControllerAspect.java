package com.example.HttpServerExercise8.aop;

import com.example.HttpServerExercise8.annotations.InitLog;
import com.example.HttpServerExercise8.enums.HttpVerb;
import com.example.HttpServerExercise8.utils.Counter;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@Component
@Aspect
@ConditionalOnExpression("${aspect.enabled:true}")
@RequiredArgsConstructor
public class ControllerAspect {
    private final Counter requestCounter;
    private final Logger logger = LogManager.getLogger("request-logger");

    @Around("@annotation(com.example.HttpServerExercise8.annotations.InitLog)")
    public Object initLog(ProceedingJoinPoint jp) throws Throwable {
        incrementCounterAndInitThreadContext();

        InitLog initLog = ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(InitLog.class);
        String resourceName = initLog.resourceName();
        HttpVerb httpVerb = initLog.httpVerb();

        logger.info("Incoming request | #{} | resource: {} | HTTP Verb {}", requestCounter.getCounter(), resourceName, httpVerb.name().toUpperCase());

        long startTime = System.currentTimeMillis();
        Object object = jp.proceed();
        long endTime = System.currentTimeMillis();

        logger.debug("request #{} duration: {}ms", requestCounter.getCounter(), endTime - startTime);

        return object;
    }

    private void incrementCounterAndInitThreadContext() {
        requestCounter.incrementBy1();
        ThreadContext.put("requestCounter", String.valueOf(requestCounter.getCounter()));
    }
}
