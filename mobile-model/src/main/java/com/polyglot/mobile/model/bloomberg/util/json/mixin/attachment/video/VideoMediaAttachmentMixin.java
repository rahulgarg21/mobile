package com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polyglot.mobile.model.bloomberg.attachment.BaseGenericMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.MediaAttachmentType;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoDetail;

import java.util.Map;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public abstract class VideoMediaAttachmentMixin extends BaseGenericMediaAttachment {


    @JsonAnySetter
    public abstract void addVideoDetail(String id, VideoDetail videoDetail);

    @JsonAnyGetter
    public abstract Map<String, VideoDetail> getVideoDetails();

    @JsonIgnore
    public abstract MediaAttachmentType getType();

}
