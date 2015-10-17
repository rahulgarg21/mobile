package com.polyglot.mobile.common.appconfig.impl;

import com.polyglot.mobile.common.appconfig.NYTimesKeySource;
import com.polyglot.mobile.common.common.BaseMobileCommonIT;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
@Slf4j
public class NYTimesKeySourceImplIT extends BaseMobileCommonIT {

    @Resource
    private NYTimesKeySource nyTimesKeySource;

    @Test
    public void testGetArticleSearchAPIKey() throws Exception {
        final String articleSearchAPIKey = nyTimesKeySource.getArticleSearchAPIKey();
        log.debug("articleSearchAPIKey: {}", articleSearchAPIKey);
        final String topStoriesAPIKey = nyTimesKeySource.getTopStoriesAPIKey();
        log.debug("topStoriesAPIKey: {}", topStoriesAPIKey);

    }
}