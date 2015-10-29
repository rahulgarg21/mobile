package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image;

import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
public class ImageMixinTest extends BaseMixinTest{

    final String jsonFileLocation = "data/attachment/image/image.json";

    @Test
    public void testImageDeserialization() throws Exception {
        final String id = "dynamic";
        final String height = "-1";
        final String width = "-1";
        final String sizeType = "1000";
        final String url = "http://assets.bwbx.io/images/iY_8wtPRpXIs/v1/-1x-1.jpg";
        final Image image = new Image();
        image.setId(id);
        image.setHeight(height);
        image.setWidth(width);
        image.setSizeType(sizeType);
        image.setUrl(new ArrayList(Arrays.asList(url)));
        assertJsonConversions(jsonFileLocation, Image.class, image);
    }

}