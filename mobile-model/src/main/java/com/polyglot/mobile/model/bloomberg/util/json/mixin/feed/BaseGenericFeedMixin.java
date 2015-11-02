package com.polyglot.mobile.model.bloomberg.util.json.mixin.feed;

import com.polyglot.mobile.model.bloomberg.module.FeedModule;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/16/2015.
 */
public abstract class BaseGenericFeedMixin<M extends FeedModule> {

    protected List<M> items;

}
