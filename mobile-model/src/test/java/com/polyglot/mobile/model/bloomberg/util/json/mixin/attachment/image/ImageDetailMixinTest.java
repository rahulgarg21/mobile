package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image;

import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageDetail;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
public class ImageDetailMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/attachment/image/image-details.json";

    @Test
    public void testImageDetailJsonConversion() throws Exception {

        final ImageDetail imageDetail = deserializeJsonFileToModel(jsonFileLocation, ImageDetail.class);
        final Map<String, Image> images = imageDetail.getImages();
        assertThat(images.size(), is(5));

        assertJsonSerialization(imageDetail, jsonFileLocation);
    }
}