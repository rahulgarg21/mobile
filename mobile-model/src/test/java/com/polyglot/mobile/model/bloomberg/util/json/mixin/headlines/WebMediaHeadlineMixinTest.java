package com.polyglot.mobile.model.bloomberg.util.json.mixin.headlines;

import com.polyglot.mobile.model.bloomberg.credits.author.MediaAuthorCredits;
import com.polyglot.mobile.model.bloomberg.headlines.WebMediaHeadline;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class WebMediaHeadlineMixinTest  extends BaseMixinTest{
    final String jsonFileLocation = "data/headlines/web-media-headlines.json";

    @Test
    public void testMediaAuthorCreditsJsonConversion() throws Exception {

        final WebMediaHeadline webMediaHeadline = deserializeJsonFileToModel(jsonFileLocation, WebMediaHeadline.class);

        Assert.assertThat(webMediaHeadline.getWeb(), is("What Hillary Clinton Will Face at Benghazi Hearings"));

        assertJsonSerialization(webMediaHeadline,jsonFileLocation);

    }
}