package com.polyglot.mobile.common.appconfig;

import com.polyglot.mobile.common.annotations.LogDuration;

/**
 * Created by Rajiv Singla on 10/16/2015.
 */
public interface NYTimesKeySource {
    public String getArticleSearchAPIKey();
    public String getTopStoriesAPIKey();
}
