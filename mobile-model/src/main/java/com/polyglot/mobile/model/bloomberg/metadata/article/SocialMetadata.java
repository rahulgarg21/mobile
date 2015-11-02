package com.polyglot.mobile.model.bloomberg.metadata.article;

import com.polyglot.mobile.model.bloomberg.common.BDescriptionModel;
import com.polyglot.mobile.model.bloomberg.common.BHeadlineModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class SocialMetadata implements BHeadlineModel, BDescriptionModel{

    private String twitterText;
    private String headline;
    private String description;
    private Integer image;

}
