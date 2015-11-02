package com.polyglot.mobile.model.bloomberg.feed;

import com.polyglot.mobile.model.bloomberg.module.FeedModule;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public class HomepageFeed<M extends FeedModule> extends BaseGenericFeed<M> {

    @Override
    public FeedType getType() {
        return FeedType.HOMEPAGE;
    }
}
