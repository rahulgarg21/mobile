package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.polyglot.mobile.model.bloomberg.media.FeatureMediaModule;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class FeatureMediaModuleMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/media/feature-media-module.json";

    @Test
    public void testFeatureMediaModuleJsonConversion() throws Exception {

        final FeatureMediaModule trackerMediaModule = deserializeJsonFileToModel(jsonFileLocation, FeatureMediaModule.class);

        assertJsonSerialization(trackerMediaModule, jsonFileLocation);

    }

}