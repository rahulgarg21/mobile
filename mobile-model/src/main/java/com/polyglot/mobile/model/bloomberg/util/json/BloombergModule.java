package com.polyglot.mobile.model.bloomberg.util.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageDetail;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.video.Thumbnail;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoDetail;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoMediaAttachment;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageDetailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMediaAttachmentMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video.ThumbnailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video.VideoDetailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video.VideoMediaAttachmentMixin;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
public class BloombergModule extends SimpleModule {

    public BloombergModule() {
        super("BloombergModule", new Version(1,0,0,null,"com.polyglot","mobile"));
    }

    @Override
    public void setupModule(final SetupContext setupContext) {

        //Image Mixins
        setupContext.setMixInAnnotations(Image.class, ImageMixin.class);
        setupContext.setMixInAnnotations(ImageDetail.class, ImageDetailMixin.class);
        setupContext.setMixInAnnotations(ImageMediaAttachment.class, ImageMediaAttachmentMixin.class);

        //Video Mixins
        setupContext.setMixInAnnotations(Thumbnail.class, ThumbnailMixin.class);
        setupContext.setMixInAnnotations(VideoDetail.class, VideoDetailMixin.class);
        setupContext.setMixInAnnotations(VideoMediaAttachment.class, VideoMediaAttachmentMixin.class);

    }
}
