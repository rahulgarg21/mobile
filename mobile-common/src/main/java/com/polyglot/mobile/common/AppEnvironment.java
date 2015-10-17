package com.polyglot.mobile.common;

import com.google.common.collect.ImmutableMap.Builder;

import java.util.Map;

import static com.google.common.collect.ImmutableMap.builder;

/**
 * Created by Rajiv Singla on 9/27/2015.
 */
public enum AppEnvironment {

    COMMON,
    DEV,
    QA,
    PROD;


    private static final Builder<String,AppEnvironment> mapBuilder = builder();
    static {
        for(AppEnvironment appEnvironment : AppEnvironment.values()) {
            mapBuilder.put(appEnvironment.name(), appEnvironment);
        }
    }
    public static final Map<String,AppEnvironment> appEnvironmentNameMap = mapBuilder.build();

}
