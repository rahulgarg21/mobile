package com.polyglot.mobile.model.bloomberg.util.json;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Factory to be used by clients to get Object Mapper which
 * specializes in Bloomberg Object Mapper. Concrete implementations
 * should provide different strategies to deserialize Bloomberg
 * feeds
 * <p/>
 * Created by Rajiv Singla on 10/28/2015.
 */
public interface BloombergObjectMapperFactory {

    /**
     * <p>Returns a pre configured jackson {@link ObjectMapper}
     * with all registered generic mixins that can be used to
     * deserialize bloomberg streams properly.</p>
     * <p/>
     * <p>
     * Client should be using this object mapper rather than
     * creating new {@link ObjectMapper} which may not have all
     * registered mixins or correct deserialization settings </p>
     *
     * @return properly configured Bloomberg object Mapper
     */
    public ObjectMapper getGenericObjectMapper();
}
