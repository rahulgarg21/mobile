package com.polyglot.mobile.model.bloomberg.util.json.mixin.credits.author;

import com.polyglot.mobile.model.bloomberg.credits.author.MediaAuthorCredits;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class MediaAuthorCreditsMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/credits/author/media-author-credits.json";

    @Test
    public void testMediaAuthorCreditsJsonConversion() throws Exception {

        final MediaAuthorCredits mediaAuthorCredits = deserializeJsonFileToModel(jsonFileLocation, MediaAuthorCredits.class);

        Assert.assertThat(mediaAuthorCredits.getAuthor().size(),is(1));

        assertJsonSerialization(mediaAuthorCredits,jsonFileLocation);

    }

}