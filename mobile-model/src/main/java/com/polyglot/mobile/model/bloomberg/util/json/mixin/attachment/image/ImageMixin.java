package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/27/2015.
 */
public abstract class ImageMixin {
    private String id;
    private String height;
    private String width;
    private String sizeType;
    private List<String> url;
}
