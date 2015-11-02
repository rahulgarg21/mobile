package com.polyglot.mobile.model.bloomberg.util.json.mixin.feed;

import com.polyglot.mobile.model.bloomberg.feed.HomepageFeed;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.BaseMixinTest;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by Rajiv Singla on 11/17/2015.
 */
public class HomepageFeedMixinTest extends BaseMixinTest {

    final String jsonFileLocation = "data/feed/homepage-feed.json";

    @Test
    public void testHomepageFeedConversion() throws Exception {

        final HomepageFeed homepageFeed = deserializeJsonFileToModel(jsonFileLocation, HomepageFeed.class);

        assertNotNull(homepageFeed);
        assertThat(homepageFeed.getItems().size(), is(22));

        testSerialization(homepageFeed);

    }

}