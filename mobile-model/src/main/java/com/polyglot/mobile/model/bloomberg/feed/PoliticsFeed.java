package com.polyglot.mobile.model.bloomberg.feed;

import com.polyglot.mobile.model.bloomberg.module.FeedModule;
import lombok.Data;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
@Data
public class PoliticsFeed<M extends FeedModule> extends BaseGenericFeed<M> {

    @Override
    public FeedType getType() {
        return FeedType.POLITICS;
    }
}
