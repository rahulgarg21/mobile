package com.polyglot.mobile.model.bloomberg.attachment.image;

import com.polyglot.mobile.model.bloomberg.attachment.BaseGenericMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.MediaAttachmentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
@EqualsAndHashCode(callSuper = false)
@Data
public class ImageMediaAttachment extends BaseGenericMediaAttachment {

    private Map<String, ImageDetail> imageDetails = new LinkedHashMap<>();
    private Boolean _expanded;

    @Override
    public MediaAttachmentType getType() {
        return MediaAttachmentType.IMAGE;
    }

    public void addImageDetail(String id, ImageDetail imageDetail) {
        imageDetails.put(id, imageDetail);
    }

}
