package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by Rajiv Singla on 11/11/2015.
 */
@JsonTypeName("ad")
public abstract class AdMediaModuleMixin {

    private String id;
    private String adType;
    private String type;

}
