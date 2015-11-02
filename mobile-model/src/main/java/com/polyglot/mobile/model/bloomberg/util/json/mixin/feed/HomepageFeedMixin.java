package com.polyglot.mobile.model.bloomberg.util.json.mixin.feed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polyglot.mobile.model.bloomberg.feed.FeedType;
import com.polyglot.mobile.model.bloomberg.module.FeedModule;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public abstract class HomepageFeedMixin<M extends FeedModule> extends BaseGenericFeedMixin<M> {

    @JsonIgnore
    public abstract FeedType getType();
}
