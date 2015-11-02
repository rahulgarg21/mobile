package com.polyglot.mobile.model.bloomberg.util.json.mixin.module;

import com.polyglot.mobile.model.bloomberg.media.ModuleMedia;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/10/2015.
 */
public abstract class BaseGenericFeedModuleMixin<M extends ModuleMedia> {

    protected String id;
    protected List<M> items;
    protected DateTime updatedAt;
    protected String searchPath;
    protected String type;
    protected String title;

}
