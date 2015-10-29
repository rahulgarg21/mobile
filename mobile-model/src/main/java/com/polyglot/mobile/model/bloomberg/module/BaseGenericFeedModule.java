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

    private String id;
    private List<M> items;
    private DateTime updatedAt;
    private boolean autofill;
    private String searchPath;
    private String type;

}
