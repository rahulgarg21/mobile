package com.polyglot.mobile.common.appconfig.impl;

import com.polyglot.mobile.common.MobileConstants;
import com.polyglot.mobile.common.annotations.LogDuration;
import com.polyglot.mobile.common.appconfig.NYTimesKeySource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import static com.polyglot.mobile.common.MobileConstants.JMX_PREFIX;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
@ManagedResource(description = JMX_PREFIX + "=com.polyglot.mobile.common.appconfig.impl.NYTimesKeySourceImpl")
public class NYTimesKeySourceImpl implements NYTimesKeySource {

    @Value("${NYTIMES.ARTICLE_SEARCH_API.KEY}")
    private String articleSearchAPIKey;

    @Value("${NYTIMES.TOP_STORIES_API.KEY}")
    private String topStoriesAPIKey;

    @Override
    @ManagedOperation
    public String getArticleSearchAPIKey() {
        return articleSearchAPIKey;
    }

    @Override
    @ManagedOperation
    public String getTopStoriesAPIKey() {
        return topStoriesAPIKey;
    }
}
