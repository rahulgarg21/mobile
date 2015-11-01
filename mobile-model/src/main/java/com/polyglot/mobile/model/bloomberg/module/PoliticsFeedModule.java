package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.media.ModuleMedia;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PoliticsFeedModule<M extends ModuleMedia> extends BaseGenericFeedModule<M> {

}
