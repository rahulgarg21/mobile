package com.polyglot.mobile.model.bloomberg.feed;

import com.polyglot.mobile.model.bloomberg.module.FeedModule;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/22/2015.
 */
public abstract class BaseGenericFeed<M extends FeedModule> implements GenericFeed<M> {

    protected final List<M> items;
    protected final boolean _expanded;

    public BaseGenericFeed(final List<M> items, final boolean _expanded) {

        this.items = items;
        this._expanded = _expanded;
    }

    public boolean is_expanded() {
        return _expanded;
    }

    @Override
    public List<M> getItems() {
        return items;

    }
}
