package com.polyglot.mobile.model.bloomberg.metadata.article;

import com.polyglot.mobile.model.bloomberg.metadata.BaseDiffMetaData;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/12/2015.
 */
@Data
public class ImageAttachmentMetadata extends BaseDiffMetaData {

    protected List<String> addValues;

}
