package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.media.BMedia;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public class PoliticsFeedModule<M extends BMedia> extends BaseGenericFeedModule<M> {

    public PoliticsFeedModule(final String id, final List<M> items, final DateTime updatedAt,
                              final boolean autofill, final String searchPath, final String type) {
        super(id, items, updatedAt, autofill, searchPath, type);
    }

}
