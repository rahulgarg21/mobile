package com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article;

import com.polyglot.mobile.model.bloomberg.metadata.article.LedeMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SeoMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SocialMetadata;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public abstract class ArticleMetadataMixin {

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
