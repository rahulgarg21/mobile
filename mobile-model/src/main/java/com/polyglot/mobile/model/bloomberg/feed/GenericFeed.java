package com.polyglot.mobile.model.bloomberg.feed;

import com.polyglot.mobile.model.bloomberg.common.BItemsModel;
import com.polyglot.mobile.model.bloomberg.common.BTypeModel;
import com.polyglot.mobile.model.bloomberg.module.FeedModule;

/**
 * Most Generic Feed Containers are expected to contain one
 * or more Feed Modules
 * <p/>
 * Created by Rajiv Singla on 10/22/2015.
 */
public interface GenericFeed<M extends FeedModule> extends BItemsModel<M>, BTypeModel<FeedType> {

}
