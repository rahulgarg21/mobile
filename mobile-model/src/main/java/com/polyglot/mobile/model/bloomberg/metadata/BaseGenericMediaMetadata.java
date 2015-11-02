package com.polyglot.mobile.model.bloomberg.metadata;

import com.polyglot.mobile.model.bloomberg.metadata.article.LedeMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SeoMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SocialMetadata;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public abstract class BaseGenericMediaMetadata implements GenericMediaMetadata {

    private Integer flowcmsId;
    private String thumbnail;
    private String background;
    private SeoMetadata seo;
    private Boolean googleStandout;
    private SocialMetadata social;
    private String ledeTreatment;
    private LedeMetadata lede;
    private String adCode;
    private Boolean disableAds;
    private Boolean suppressRecirc;

}
