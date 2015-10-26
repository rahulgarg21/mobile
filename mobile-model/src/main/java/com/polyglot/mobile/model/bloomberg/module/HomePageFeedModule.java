package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.media.BMedia;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public class HomepageFeedModule<M extends BMedia> extends BaseGenericFeedModule<M> {

    private int size;
    private String heroType;

    public HomepageFeedModule(final String id, final List<M> items, final DateTime updatedAt,
                              final boolean autofill, final String serachPath, final String type) {
        super(id, items, updatedAt, autofill, serachPath, type);
    }

    public HomepageFeedModule(final String id, final List<M> items, final DateTime updatedAt, final boolean autofill,
                              final String serachPath, final String type,
                              final int size, final String heroType) {
        super(id, items, updatedAt, autofill, serachPath, type);
        this.size = size;
        this.heroType = heroType;
    }

    public int getSize() {
        return size;
    }

    public String getHeroType() {
        return heroType;
    }

}
