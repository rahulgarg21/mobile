package com.polyglot.mobile.common.appconfig.impl;

import com.polyglot.mobile.common.appconfig.NYTimesKeySource;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
@Getter
public class NYTimesKeySourceImpl implements NYTimesKeySource {

    @Value("${NYTIMES.ARTICLE_SEARCH_API.KEY}")
    private String articleSearchAPIKey;

    @Value("${NYTIMES.TOP_STORIES_API.KEY}")
    private String topStoriesAPIKey;
}
