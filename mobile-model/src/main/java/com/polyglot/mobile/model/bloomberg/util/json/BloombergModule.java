package com.polyglot.mobile.model.bloomberg.util.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageDetail;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageMediaAttachment;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageDetailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMediaAttachmentMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMixin;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
public class BloombergModule extends SimpleModule {

    public BloombergModule() {
        super("BloombergModule", new Version(1,0,0,null,"com.polyglot","mobile"));
    }

    @Override
    public void setupModule(final SetupContext setupContext) {
        setupContext.setMixInAnnotations(Image.class, ImageMixin.class);
        setupContext.setMixInAnnotations(ImageDetail.class, ImageDetailMixin.class);
        setupContext.setMixInAnnotations(ImageMediaAttachment.class, ImageMediaAttachmentMixin.class);
    }
}
