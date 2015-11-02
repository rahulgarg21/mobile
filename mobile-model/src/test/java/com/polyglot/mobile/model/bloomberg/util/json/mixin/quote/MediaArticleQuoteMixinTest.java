package com.polyglot.mobile.model.bloomberg.util.json.mixin.quote;

import com.polyglot.mobile.model.bloomberg.quote.MediaArticleQuote;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class MediaArticleQuoteMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/quote/media-article-quote.json";

    @Test
    public void testMediaArticleQuoteMixinJsonConversion() throws Exception {

        final MediaArticleQuote mediaArticleQuote = deserializeJsonFileToModel(jsonFileLocation, MediaArticleQuote.class);

        assertJsonSerialization(mediaArticleQuote, jsonFileLocation);

    }


}