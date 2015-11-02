package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.common.*;
import com.polyglot.mobile.model.bloomberg.media.ModuleMedia;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public interface GenericFeedModule<M extends ModuleMedia> extends FeedModule, BIdModel<String>,
        BItemsModel<M>, BUpdatedAtModel, BTypeModel<String>, BTitleModel {

}
