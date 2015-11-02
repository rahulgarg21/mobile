package com.polyglot.mobile.model.bloomberg.util.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.polyglot.mobile.model.bloomberg.util.json.custom.DateTimeSerializer;

/**
 * Factory class to be used by clients to get Object Mapper which
 * specializes in Bloomberg Object Mapper
 * <p/>
 * Created by Rajiv Singla on 10/28/2015.
 */
public class BloombergObjectMapperFactoryImpl implements BloombergObjectMapperFactory {


    @Override
    public ObjectMapper getGenericObjectMapper() {

        final ObjectMapper objectMapper = new ObjectMapper();

        //JodaTime Module Registration
        final JodaModule jodaModule = new JodaModule();
        jodaModule.addSerializer(new DateTimeSerializer());
        objectMapper.registerModule(jodaModule);

        //Bloomberg Module Registration
        objectMapper.registerModule(new BloombergModule());

        //We don't want to serialize null values
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        return objectMapper;
    }

}
