package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.polyglot.mobile.model.bloomberg.media.TrackerMediaModule;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class TrackerMediaModuleMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/media/tracker-media-module.json";

    @Test
    public void testTrackerMediaModuleJsonConversion() throws Exception {

        final TrackerMediaModule trackerMediaModule = deserializeJsonFileToModel(jsonFileLocation, TrackerMediaModule.class);

        assertJsonSerialization(trackerMediaModule, jsonFileLocation);

    }

}