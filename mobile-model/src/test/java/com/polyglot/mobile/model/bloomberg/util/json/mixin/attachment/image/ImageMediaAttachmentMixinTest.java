package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image;

import com.google.common.collect.ImmutableList;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageDetail;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageMediaAttachment;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
public class ImageMediaAttachmentMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/attachment/image/image-media-attachment.json";

    @Test
    public void testImageMediaAttachmentJsonConversion() throws Exception {
        final ImageMediaAttachment imageMediaAttachment = deserializeJsonFileToModel(
                jsonFileLocation,
                ImageMediaAttachment.class);
        final Map<String, ImageDetail> imageDetailsMap = imageMediaAttachment.getImageDetails();
        final List<ImageDetail> imageDetailsList = ImmutableList.copyOf(imageDetailsMap.values());
        assertThat(imageDetailsList.size(), is(1));
        assertJsonSerialization(imageMediaAttachment, jsonFileLocation);
    }

}