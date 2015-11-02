package com.polyglot.mobile.common.exception;

/**
 * Created by Rajiv Singla on 10/7/2015.
 */
public class MobileException extends RuntimeException {

    public MobileException() {
        super();
    }

    public MobileException(String message) {
        super(message);
    }

    public MobileException(String message, Throwable cause) {
        super(message, cause);
    }

}
