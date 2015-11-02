package com.polyglot.mobile.model.bloomberg.attachment.video;

import com.polyglot.mobile.model.bloomberg.attachment.BaseGenericMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.MediaAttachmentType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class VideoMediaAttachment extends BaseGenericMediaAttachment {

    private Map<String, VideoDetail> videoDetails = new LinkedHashMap<>();

    @Override
    public MediaAttachmentType getType() {
        return MediaAttachmentType.VIDEO;
    }

    public void addVideoDetail(String id, VideoDetail videoDetail) {
        videoDetails.put(id, videoDetail);
    }

}
