package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.common.BItemsModel;
import com.polyglot.mobile.model.bloomberg.common.BTypeModel;
import com.polyglot.mobile.model.bloomberg.common.BUpdatedAtModel;
import com.polyglot.mobile.model.bloomberg.media.ModuleMedia;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public interface GenericFeedModule<M extends ModuleMedia> extends FeedModule, BIdModel<String>,
        BItemsModel<M>, BUpdatedAtModel,BTypeModel<String> {

}
