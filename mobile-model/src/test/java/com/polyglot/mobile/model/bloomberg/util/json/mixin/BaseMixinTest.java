package com.polyglot.mobile.model.bloomberg.util.json.mixin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.polyglot.mobile.model.bloomberg.util.json.BloombergObjectMapperFactory;
import com.polyglot.mobile.model.bloomberg.util.json.BloombergObjectMapperFactoryImpl;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.skyscreamer.jsonassert.JSONAssert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
@Slf4j
public abstract class BaseMixinTest {

    protected static ObjectMapper objectMapper;

    @BeforeClass
    public static void beforeClass() {
        final BloombergObjectMapperFactory bloombergObjectMapperFactory =
                new BloombergObjectMapperFactoryImpl();
        objectMapper = bloombergObjectMapperFactory.getGenericObjectMapper();
    }

    public static <T> T deserializeJsonFileToModel(String jsonFileLocation, Class<T> modelClass) {
        final InputStream jsonFileInputStream = BaseMixinTest.class.getClassLoader().getResourceAsStream(jsonFileLocation);
        Assert.assertNotNull("Json File Location must be valid", jsonFileInputStream);
        try {
            return objectMapper.readValue(jsonFileInputStream, modelClass);
        } catch (IOException ex) {
            log.error("Error while doing assert Json for jsonFileLocation: {}, modelClass: {}, Exception {}",
                    jsonFileLocation, modelClass, ex);
            throw new RuntimeException(ex);
        }
    }

    public static <T> T assertJsonDeserialization(String jsonFileLocation, Class<T> modelClass, T expectedJsonObject) {
        final T actualValue = deserializeJsonFileToModel(jsonFileLocation, modelClass);
        assertThat(actualValue, is(expectedJsonObject));
        return actualValue;
    }

    public static String serializeModelToJson(Object model) throws JsonProcessingException {
        return objectMapper.writeValueAsString(model);
    }

    public static void assertJsonSerialization(Object model, String expectedJsonFileLocation) {
        try {
            final String actualModelString = serializeModelToJson(model);
            JSONAssert.assertEquals(fromStream(expectedJsonFileLocation), actualModelString, true);
        } catch (IOException | JSONException ex) {
            log.error("Error while doing assert Json serialization Assertion: model: {}, " +
                    "expected Json File Location: {}, Exception {}", model, expectedJsonFileLocation, ex);
            throw new RuntimeException(ex);
        }

    }


    /**
     * Checks both serialization and deserialization of given expected Json object
     *
     * @param jsonFileLocation   Classpath location of the json file
     * @param modelClass         Class type
     * @param expectedJsonObject Expected Json Object
     * @param <T>                Json Model Type
     */

    public static <T> void assertJsonConversions(String jsonFileLocation, Class<T> modelClass, T expectedJsonObject) {
        //first check deserialization
        final T actualValue = assertJsonDeserialization(jsonFileLocation, modelClass, expectedJsonObject);
        //then check serialization
        assertJsonSerialization(actualValue, jsonFileLocation);
    }

    public static String fromStream(String jsonFileLocation) throws IOException {
        final InputStream jsonFileInputStream = BaseMixinTest.class.getClassLoader().getResourceAsStream(jsonFileLocation);
        final BufferedReader reader = new BufferedReader(new InputStreamReader(jsonFileInputStream));
        final StringBuilder result = new StringBuilder();
        final String newLine = System.getProperty("line.separator");
        String line = reader.readLine();
        while (line != null) {
            result.append(line);
            result.append(newLine);
            line = reader.readLine();
        }
        jsonFileInputStream.close();
        return result.toString();
    }

}
