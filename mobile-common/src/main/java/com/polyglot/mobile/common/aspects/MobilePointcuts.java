package com.polyglot.mobile.common.aspects;

import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by Rajiv Singla on 10/18/2015.
 */
public class MobilePointcuts {

    @Pointcut("execution(public com.polyglot.mobile.common.appconfig.impl.* *(..))")
    public void anyPublicOperation() {}

    @Pointcut("within(com.polyglot.mobile..*)")
    public void inMobile() {}

    @Pointcut("@annotation(com.polyglot.mobile.common.annotations.LogDuration)")
    public void hasLogDurationAnnotation(){}

    @Pointcut("anyPublicOperation() && hasLogDurationAnnotation()")
    public void logDurationPointcut() {}
}
