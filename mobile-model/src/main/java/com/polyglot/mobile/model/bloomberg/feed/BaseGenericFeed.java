package com.polyglot.mobile.model.bloomberg.feed;

import com.polyglot.mobile.model.bloomberg.module.FeedModule;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/22/2015.
 */
@Data
public abstract class BaseGenericFeed<M extends FeedModule> implements GenericFeed<M> {

    protected List<M> items;

}
