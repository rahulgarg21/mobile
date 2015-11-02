package com.polyglot.mobile.model.bloomberg.media;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public enum ModuleMediaType {

    ARTICLE("article"),
    TRACKER("tracker"),
    FEATURE("feature"),
    VIDEO("video");

    private String description;

    private ModuleMediaType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }


}
