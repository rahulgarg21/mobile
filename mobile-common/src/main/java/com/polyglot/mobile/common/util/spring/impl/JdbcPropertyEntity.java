package com.polyglot.mobile.common.util.spring.impl;

import com.polyglot.mobile.common.AppEnvironment;
import lombok.Builder;
import lombok.Getter;

/**
 * Created by Rajiv Singla on 10/7/2015.
 */
@Builder
@Getter
public class JdbcPropertyEntity {

    private final AppEnvironment appEnvironment;
    private final String propertyKey;
    private final String propertyValue;

}
