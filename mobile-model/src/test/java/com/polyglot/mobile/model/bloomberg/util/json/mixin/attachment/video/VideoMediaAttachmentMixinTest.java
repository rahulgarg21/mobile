package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video;

import com.google.common.collect.ImmutableList;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoDetail;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoMediaAttachment;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class VideoMediaAttachmentMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/attachment/video/video-media-attachment.json";

    @Test
    public void testVideoMediaAttachmentJsonConversion() throws Exception {
        final VideoMediaAttachment videoMediaAttachment = deserializeJsonFileToModel(
                jsonFileLocation,
                VideoMediaAttachment.class);

        final Map<String, VideoDetail> videoDetailsMap = videoMediaAttachment.getVideoDetails();

        final ImmutableList<VideoDetail> videoDetailsList = ImmutableList.copyOf(videoDetailsMap.values());
        assertThat(videoDetailsList.size(), is(1));
        assertJsonSerialization(videoMediaAttachment, jsonFileLocation);
    }

}