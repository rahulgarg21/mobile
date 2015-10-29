package com.polyglot.mobile.model.bloomberg.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
public interface BloombergObjectMapperFactory {
    ObjectMapper getGenericObjectMapper();
}
