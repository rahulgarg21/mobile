package com.polyglot.mobile.model.bloomberg.feed;

import com.polyglot.mobile.model.bloomberg.module.FeedModule;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public class PoliticsFeed<M extends FeedModule> extends BaseGenericFeed<M> {


    public PoliticsFeed(final List<M> items, final boolean _expanded) {
        super(items, _expanded);
    }

    @Override
    public FeedType getType() {
        return FeedType.POLITICS;
    }
}