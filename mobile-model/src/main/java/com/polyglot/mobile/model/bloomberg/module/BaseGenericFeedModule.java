package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.media.BMedia;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public abstract class BaseGenericFeedModule<M extends BMedia> implements GenericFeedModule<M> {

    private final String id;
    private final List<M> items;
    private final DateTime updatedAt;
    private final boolean autofill;
    private final String searchPath;
    private final String type;

    public BaseGenericFeedModule(final String id, final List<M> items, final DateTime updatedAt,
                                 final boolean autofill, final String searchPath, final String type) {
        this.id = id;
        this.items = items;
        this.updatedAt = updatedAt;
        this.autofill = autofill;
        this.searchPath = searchPath;
        this.type = type;
    }


    @Override
    public String getId() {
        return id;
    }

    @Override
    public List<M> getItems() {
        return items;
    }

    @Override
    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public boolean isAutofill() {
        return autofill;
    }

    public String getSearchPath() {
        return searchPath;
    }

    @Override
    public String getType() {
        return type;
    }
}
