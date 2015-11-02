package com.polyglot.mobile.model.bloomberg.util.json.mixin.feed;

import com.polyglot.mobile.model.bloomberg.feed.PoliticsFeed;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 11/17/2015.
 */
public class PoliticsFeedMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/feed/politics-feed.json";

    @Test
    public void testPoliticsFeedConversion() throws Exception {

        final PoliticsFeed politicsFeed = deserializeJsonFileToModel(jsonFileLocation, PoliticsFeed.class);

        assertNotNull(politicsFeed);
        assertThat(politicsFeed.getItems().size(), is(13));

        testSerialization(politicsFeed);

    }

}