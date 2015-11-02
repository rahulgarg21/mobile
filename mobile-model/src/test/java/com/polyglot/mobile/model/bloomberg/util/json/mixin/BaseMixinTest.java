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

import java.io.*;
import java.net.URL;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Base class for all Mixin Tests.
 * <p/>
 * Contains various utility methods for json serialization, deserialization and json comparison
 * <p/>
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

    /**
     * Deserialize given Json file location to given model class and returns it back without any validation check
     *
     * @param jsonFileLocation Classpath location of the json file
     * @param modelClass       Model Class type
     * @param <T>              Json Model Type
     * @return
     */
    public static <T> T deserializeJsonFileToModel(String jsonFileLocation, Class<T> modelClass) {
        final InputStream jsonFileInputStream = BaseMixinTest.class.getClassLoader().getResourceAsStream(jsonFileLocation);
        Assert.assertNotNull("Json File Location must be valid", jsonFileInputStream);
        try {
            return objectMapper.readValue(jsonFileInputStream, modelClass);
        } catch (IOException ex) {
            log.error("Error while doing assert Json for fileLocation: {}, modelClass: {}, Exception {}",
                    jsonFileLocation, modelClass, ex);
            throw new RuntimeException(ex);
        } finally {
            try {
                jsonFileInputStream.close();
            } catch (IOException e) {
                log.error("Error while closing input stream at file location: {}", jsonFileLocation);
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Deserialize given Json file location to given model class and then validates deserialization by comparing it
     * with given expected Object
     *
     * @param jsonFileLocation   Classpath location of the json file
     * @param modelClass         Model Class type
     * @param expectedJsonObject Expected Json Object
     * @param <T>                Json Model Type
     * @return deserialized actual value if expected Json Object matches deserialized object
     */
    public static <T> T assertJsonDeserialization(String jsonFileLocation, Class<T> modelClass, T expectedJsonObject) {
        final T actualValue = deserializeJsonFileToModel(jsonFileLocation, modelClass);
        assertThat(actualValue, is(expectedJsonObject));
        return actualValue;
    }

    public static String serializeModelToJson(Object model) throws JsonProcessingException {
        return objectMapper.writeValueAsString(model);
    }

    /**
     * Converts given model to json string and compare it with json present at given file location
     *
     * @param model                    Model which needs to be compared
     * @param expectedJsonFileLocation Location of file containing expected json string
     */
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

    /**
     * Converts given file location to String
     *
     * @param fileLocation location of the file which needs to be converted to String
     * @return Contents of file as string
     * @throws IOException
     */
    public static String fromStream(String fileLocation) throws IOException {
        final InputStream jsonFileInputStream = BaseMixinTest.class.getClassLoader().getResourceAsStream(fileLocation);
        Assert.assertNotNull("Json File Location must be valid", jsonFileInputStream);
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


    /**
     * Checks if object can be serialized properly
     *
     * @param object
     * @throws Exception
     */
    public static void testSerialization(Object object) throws Exception{
        final URL location = BaseMixinTest.class.getProtectionDomain().getCodeSource().getLocation();
        final File homepageSerializationFile =
                new File(location.getPath() + String.format("serialization/%s.ser",object.getClass().getSimpleName()));
        homepageSerializationFile.getParentFile().mkdirs();
        final FileOutputStream fileOutputStream = new FileOutputStream(homepageSerializationFile);
        final ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
        fileOutputStream.close();
    }

}
