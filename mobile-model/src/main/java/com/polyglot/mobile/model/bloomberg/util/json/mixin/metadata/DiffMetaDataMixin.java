package com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.polyglot.mobile.model.bloomberg.metadata.article.AllAttachmentsDiffMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.ImageAttachmentMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SimpleDiffMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.VideoAttachmentMetadata;

/**
 * Created by Rajiv Singla on 11/12/2015.
 */

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "field",
        defaultImpl = SimpleDiffMetadata.class)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ImageAttachmentMetadata.class, name = "attachments.image"),
        @JsonSubTypes.Type(value = VideoAttachmentMetadata.class, name = "attachments.video"),
        @JsonSubTypes.Type(value = AllAttachmentsDiffMetadata.class, name = "attachments.all")
})
public abstract class DiffMetaDataMixin {

}
