package com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata;

import com.polyglot.mobile.model.bloomberg.metadata.DiffMetaData;
import com.polyglot.mobile.model.bloomberg.metadata.article.SeoMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SocialMetadata;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public abstract class BaseGenericMediaMetadataMixin<T extends DiffMetaData> {

    private Integer flowcmsId;
    private String thumbnail;
    private String background;
    private SeoMetadata seo;
    private Boolean googleStandout;
    private SocialMetadata social;
    private String ledeTreatment;
    private String adCode;
    private Boolean disableAds;
    private Boolean suppressRecirc;
    private List<T> diff;

}
