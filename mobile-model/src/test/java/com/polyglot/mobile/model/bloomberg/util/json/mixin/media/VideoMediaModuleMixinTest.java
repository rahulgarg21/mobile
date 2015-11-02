package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.polyglot.mobile.model.bloomberg.media.VideoMediaModule;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class VideoMediaModuleMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/media/video-media-module.json";

    @Test
    public void testVideoMediaModuleJsonConversion() throws Exception {

        final VideoMediaModule videoMediaModule = deserializeJsonFileToModel(jsonFileLocation, VideoMediaModule.class);

        assertJsonSerialization(videoMediaModule, jsonFileLocation);

    }

}