package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image;

import com.polyglot.mobile.model.bloomberg.attachment.image.Image;

import java.util.Map;

/**
 * Created by Rajiv Singla on 10/27/2015.
 */
public abstract class ImageDetailMixin {
    private String baseUrl;
    private String title;
    private String description;
    private String caption;
    private String credit;
    private Integer origWidth;
    private Map<String, Image> images;
}
