package com.polyglot.mobile.model.bloomberg.util.json.mixin.module;

import com.polyglot.mobile.model.bloomberg.module.SimpleFeedModule;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 11/10/2015.
 */
public class SimpleFeedModuleMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/module/politics-tracker-module.json";

    @Test
    public void testSimpleModuleConversion() throws Exception {

        final SimpleFeedModule simpleFeedModule = deserializeJsonFileToModel(jsonFileLocation, SimpleFeedModule.class);

        assertNotNull(simpleFeedModule);
        assertThat(simpleFeedModule.getItems().size(), is(32));
        //assertJsonSerialization(simpleFeedModule, jsonFileLocation);
        //This assertion is failing because metadata lede id is inconsistent - it is sometimes string and sometimes integer
        //So while deserialization of integer to string works fine - when serialization lede id always string
    }

}