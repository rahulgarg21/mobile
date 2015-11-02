package com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article;

import com.polyglot.mobile.model.bloomberg.metadata.article.ArticleMetadata;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class ArticleMetadataMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/metadata/article/article-metadata.json";

    @Test
    public void testArticleMetadataMixinJsonConversion() throws Exception {

        final ArticleMetadata articleMetadata = deserializeJsonFileToModel(jsonFileLocation, ArticleMetadata.class);

        Assert.assertNotNull(articleMetadata.getLede());

        assertJsonSerialization(articleMetadata, jsonFileLocation);

    }


}