package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.polyglot.mobile.model.bloomberg.media.ArticleMediaModule;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class ArticleMediaModuleMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/media/article-media-module.json";

    @Test
    public void testArticleMediaModuleJsonConversion() throws Exception {

        final ArticleMediaModule articleMediaModule = deserializeJsonFileToModel(jsonFileLocation, ArticleMediaModule.class);

        Assert.assertThat(articleMediaModule.getAttachments().getImage().getImageDetails().size(), is(1));

        assertJsonSerialization(articleMediaModule, jsonFileLocation);

    }

}