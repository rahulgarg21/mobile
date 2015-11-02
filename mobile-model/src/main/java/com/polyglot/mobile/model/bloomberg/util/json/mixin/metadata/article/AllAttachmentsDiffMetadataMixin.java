package com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article;

import com.polyglot.mobile.model.bloomberg.metadata.article.AllAttachementsAddValuesMetadata;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.BaseDiffMetaDataMixin;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/11/2015.
 */
public abstract class AllAttachmentsDiffMetadataMixin extends BaseDiffMetaDataMixin {

    private List<AllAttachementsAddValuesMetadata> addValues;
    private String field;
    private String diffKey;

}


