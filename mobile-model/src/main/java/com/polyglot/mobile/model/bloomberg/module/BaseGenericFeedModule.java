package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.media.ModuleMedia;
import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
@Data
public abstract class BaseGenericFeedModule<M extends ModuleMedia> implements GenericFeedModule<M> {

    protected String id;
    protected List<M> items;
    protected DateTime updatedAt;
    protected String searchPath;
    protected String type;
    protected String title;

}
