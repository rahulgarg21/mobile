package com.polyglot.mobile.model.bloomberg.attachment.image;

import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/27/2015.
 */
@Data
public class Image {
    private String id;
    private String height;
    private String width;
    private String sizeType;
    private List<String> url;

}
