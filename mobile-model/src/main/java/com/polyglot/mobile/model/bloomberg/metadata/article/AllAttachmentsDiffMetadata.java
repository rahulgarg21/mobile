package com.polyglot.mobile.model.bloomberg.metadata.article;

import com.polyglot.mobile.model.bloomberg.metadata.BaseDiffMetaData;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/11/2015.
 */
@Data
public class AllAttachmentsDiffMetadata extends BaseDiffMetaData {

    private List<AllAttachementsAddValuesMetadata> addValues;
    private String diffKey;

}


