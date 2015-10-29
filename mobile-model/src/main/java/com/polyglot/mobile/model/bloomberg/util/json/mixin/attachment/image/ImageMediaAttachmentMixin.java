package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image;

import com.fasterxml.jackson.annotation.*;
import com.polyglot.mobile.model.bloomberg.attachment.MediaAttachmentType;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageDetail;

import java.util.Map;

/**
 * Created by Rajiv Singla on 10/27/2015.
 */
@JsonPropertyOrder({"imageDetails","_expanded"})
public abstract class ImageMediaAttachmentMixin {

    @JsonAnySetter
    public abstract void addImageDetail(String id, ImageDetail imageDetail);

    @JsonAnyGetter
    public abstract Map<String,ImageDetail> getImageDetails();

    @JsonProperty("_expanded")
    private boolean _expanded;

    @JsonIgnore
    public abstract MediaAttachmentType getType();

}
