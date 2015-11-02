package com.polyglot.mobile.model.bloomberg.util.json.mixin.feed;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polyglot.mobile.model.bloomberg.feed.FeedType;
import com.polyglot.mobile.model.bloomberg.module.FeedModule;


public abstract class PoliticsFeedMixin<M extends FeedModule> extends BaseGenericFeedMixin<M> {

    @JsonIgnore
    public abstract FeedType getType();
}
