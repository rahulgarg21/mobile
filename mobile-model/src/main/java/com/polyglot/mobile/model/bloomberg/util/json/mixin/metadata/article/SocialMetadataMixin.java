package com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article;

import com.polyglot.mobile.model.bloomberg.common.BDescriptionModel;
import com.polyglot.mobile.model.bloomberg.common.BHeadlineModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public abstract class SocialMetadataMixin{

    private String twitterText;
    private String headline;
    private String description;
    private Integer image;

}
