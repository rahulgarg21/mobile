package com.polyglot.mobile.model.bloomberg.util.json.mixin.tags;

import com.polyglot.mobile.model.bloomberg.tags.MediaArticleTags;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.number.OrderingComparison.greaterThanOrEqualTo;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class MediaArticleTagMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/tags/media-article-tags.json";

    @Test
    public void testMediaArticleTagMixinJsonConversion() throws Exception {

        final MediaArticleTags mediaArticleTags = deserializeJsonFileToModel(jsonFileLocation, MediaArticleTags.class);
        Assert.assertThat(mediaArticleTags.getTopics().size(), greaterThan(1));
        Assert.assertThat(mediaArticleTags.getLabels().size(), greaterThanOrEqualTo(1));
        assertJsonSerialization(mediaArticleTags, jsonFileLocation);

    }

}