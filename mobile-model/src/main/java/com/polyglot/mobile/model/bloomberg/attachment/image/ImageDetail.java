package com.polyglot.mobile.model.bloomberg.attachment.image;

import lombok.Data;

import java.util.Map;

/**
 * Created by Rajiv Singla on 10/27/2015.
 */
@Data
public class ImageDetail {

    private String baseUrl;
    private String title;
    private String description;
    private Integer origWidth;
    private Map<String, Image> images;


}
