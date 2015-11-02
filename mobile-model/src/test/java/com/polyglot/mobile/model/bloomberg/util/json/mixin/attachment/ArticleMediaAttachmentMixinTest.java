package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment;

import com.polyglot.mobile.model.bloomberg.attachment.ArticleMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoMediaAttachment;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class ArticleMediaAttachmentMixinTest extends BaseMixinTest{

    @Test
    public void testArticleMediaAttachmentJsonConversion() throws Exception {
        final String jsonFileLocation = "data/attachment/article-media-attachment.json";
        final ArticleMediaAttachment articleMediaAttachment = deserializeJsonFileToModel(
                jsonFileLocation,
                ArticleMediaAttachment.class);

        final ImageMediaAttachment image = articleMediaAttachment.getImage();
        final VideoMediaAttachment video = articleMediaAttachment.getVideo();

        Assert.assertThat(image.getImageDetails().size(),is(1));
        Assert.assertThat(video.getVideoDetails().size(),is(1));

        assertJsonSerialization(articleMediaAttachment, jsonFileLocation);
    }

    @Test
    public void testArticleMediaAttachmentWithNoVideoJsonConversion() throws Exception {
        final String jsonFileLocation = "data/attachment/article-media-attachment-no-video.json";
        final ArticleMediaAttachment articleMediaAttachment = deserializeJsonFileToModel(
                jsonFileLocation,
                ArticleMediaAttachment.class);

        final ImageMediaAttachment image = articleMediaAttachment.getImage();
        final VideoMediaAttachment video = articleMediaAttachment.getVideo();

        Assert.assertThat(image.getImageDetails().size(),is(1));
        Assert.assertThat(video.getVideoDetails().size(),is(0));

        assertJsonSerialization(articleMediaAttachment, jsonFileLocation);
    }

    @Test
    public void testArticleMediaAttachmentWithNoImageJsonConversion() throws Exception {
        final String jsonFileLocation = "data/attachment/article-media-attachment-no-image.json";
        final ArticleMediaAttachment articleMediaAttachment = deserializeJsonFileToModel(
                jsonFileLocation,
                ArticleMediaAttachment.class);

        final ImageMediaAttachment image = articleMediaAttachment.getImage();
        final VideoMediaAttachment video = articleMediaAttachment.getVideo();

        Assert.assertThat(image.getImageDetails().size(),is(0));
        Assert.assertThat(video.getVideoDetails().size(),is(1));

        assertJsonSerialization(articleMediaAttachment, jsonFileLocation);
    }
}