package com.polyglot.mobile.common.aspects;

import com.google.common.base.Stopwatch;
import com.polyglot.mobile.common.annotations.LogDuration;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by Rajiv Singla on 10/18/2015.
 */
@Aspect
@Component
@Slf4j
public class LogDurationAspect {

    @Around(value = "MobilePointcuts.logDurationPointcut() && @annotation(logDuration)")
    public Object logMethodDurationAdvice(final ProceedingJoinPoint proceedingJoinPoint,
                                          final LogDuration logDuration) throws Throwable {

        log.debug("The method: {} execution started with args: {}, LogDuration value: {}",
                proceedingJoinPoint.getSignature().getName(),
                Arrays.toString(proceedingJoinPoint.getArgs()),
                logDuration.value());
        final Stopwatch stopwatch = Stopwatch.createStarted();

        Object result = proceedingJoinPoint.proceed();

        log.info("The method: {} execution completed with result: {}, LogDuration value: {}, Time Taken: {}",
                proceedingJoinPoint.getSignature().getName(),
                result.toString(),
                logDuration.value(),
                stopwatch.stop());
        return result;

    }
}
