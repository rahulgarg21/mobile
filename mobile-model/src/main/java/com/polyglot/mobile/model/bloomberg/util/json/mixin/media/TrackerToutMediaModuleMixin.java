package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Created by Rajiv Singla on 11/11/2015.
 */
@JsonTypeName("trackerTout")
public abstract class TrackerToutMediaModuleMixin {

    private String headline;
    private String id;
    private String type;
    private String url;
    private String toutDek;

}
