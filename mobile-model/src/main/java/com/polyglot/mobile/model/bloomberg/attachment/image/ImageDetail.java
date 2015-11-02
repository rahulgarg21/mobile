package com.polyglot.mobile.model.bloomberg.attachment.image;

import com.polyglot.mobile.model.bloomberg.common.BCaptionModel;
import com.polyglot.mobile.model.bloomberg.common.BDescriptionModel;
import com.polyglot.mobile.model.bloomberg.common.BTitleModel;
import lombok.Data;

import java.util.Map;

/**
 * Created by Rajiv Singla on 10/27/2015.
 */
@Data
public class ImageDetail implements BTitleModel, BDescriptionModel, BCaptionModel {

    private String baseUrl;
    private String title;
    private String description;
    private String caption;
    private String credit;
    private Integer origWidth;
    private Map<String, Image> images;

}
