package com.polyglot.mobile.model.bloomberg.attachment.image;

import com.polyglot.mobile.model.bloomberg.common.BUrlsModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 10/27/2015.
 */
@Data
public class Image implements BUrlsModel {

    private String id;
    private String height;
    private String width;
    private String sizeType;
    private List<String> url;

}
