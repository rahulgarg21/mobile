package com.polyglot.mobile.common.util.spring;

import com.polyglot.mobile.common.AppEnvironment;

import java.util.Map;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
public interface JdbcPropertySource {

    public Object getProperty(String name);

    public void loadPropertyCache();

    public Map<AppEnvironment, Map<String, String>> getAllCachedProperties();

    public void evictPropertyCache();
}
