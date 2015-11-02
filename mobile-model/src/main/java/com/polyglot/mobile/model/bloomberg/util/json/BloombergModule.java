package com.polyglot.mobile.model.bloomberg.util.json;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.polyglot.mobile.model.bloomberg.attachment.ArticleMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.image.Image;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageDetail;
import com.polyglot.mobile.model.bloomberg.attachment.image.ImageMediaAttachment;
import com.polyglot.mobile.model.bloomberg.attachment.video.Thumbnail;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoDetail;
import com.polyglot.mobile.model.bloomberg.attachment.video.VideoMediaAttachment;
import com.polyglot.mobile.model.bloomberg.credits.author.MediaAuthor;
import com.polyglot.mobile.model.bloomberg.credits.author.MediaAuthorCredits;
import com.polyglot.mobile.model.bloomberg.headlines.WebMediaHeadline;
import com.polyglot.mobile.model.bloomberg.media.ArticleMediaModule;
import com.polyglot.mobile.model.bloomberg.media.TrackerMediaModule;
import com.polyglot.mobile.model.bloomberg.metadata.article.ArticleMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.LedeMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SeoMetadata;
import com.polyglot.mobile.model.bloomberg.metadata.article.SocialMetadata;
import com.polyglot.mobile.model.bloomberg.quote.MediaArticleQuote;
import com.polyglot.mobile.model.bloomberg.tags.MediaArticleTags;
import com.polyglot.mobile.model.bloomberg.tags.labels.MediaLabel;
import com.polyglot.mobile.model.bloomberg.tags.topics.MediaTopic;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.ArticleMediaAttachmentMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageDetailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMediaAttachmentMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.image.ImageMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video.ThumbnailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video.VideoDetailMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.attachment.video.VideoMediaAttachmentMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.credits.author.MediaAuthorCreditsMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.credits.author.MediaAuthorMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.headlines.WebMediaHeadlineMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.media.ArticleMediaModuleMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.media.TrackerMediaModuleMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article.ArticleMetadataMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article.LedeMetadataMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article.SeoMetadataMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.metadata.article.SocialMetadataMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.quote.MediaArticleQuoteMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.tags.MediaArticleTagMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.tags.labels.MediaLabelMixin;
import com.polyglot.mobile.model.bloomberg.util.json.mixin.tags.topics.MediaTopicMixin;

/**
 * Created by Rajiv Singla on 10/28/2015.
 */
public class BloombergModule extends SimpleModule {

    public BloombergModule() {
        super("BloombergModule", new Version(1, 0, 0, null, "com.polyglot", "mobile"));
    }

    @Override
    public void setupModule(final SetupContext setupContext) {

        //--------------------------MEDIA ATTACHMENTS MIXINS ------------------------------//
        //Image Mixins
        setupContext.setMixInAnnotations(Image.class, ImageMixin.class);
        setupContext.setMixInAnnotations(ImageDetail.class, ImageDetailMixin.class);
        setupContext.setMixInAnnotations(ImageMediaAttachment.class, ImageMediaAttachmentMixin.class);

        //Video Mixins
        setupContext.setMixInAnnotations(Thumbnail.class, ThumbnailMixin.class);
        setupContext.setMixInAnnotations(VideoDetail.class, VideoDetailMixin.class);
        setupContext.setMixInAnnotations(VideoMediaAttachment.class, VideoMediaAttachmentMixin.class);

        //Article Media Attachment Mixin
        setupContext.setMixInAnnotations(ArticleMediaAttachment.class, ArticleMediaAttachmentMixin.class);

        //--------------------------MEDIA CREDITS MIXINS ------------------------------//
        //Author Mixins
        setupContext.setMixInAnnotations(MediaAuthor.class, MediaAuthorMixin.class);
        setupContext.setMixInAnnotations(MediaAuthorCredits.class, MediaAuthorCreditsMixin.class);

        //--------------------------MEDIA HEADLINE MIXINS ------------------------------//
        //Web Media Headline Mixins
        setupContext.setMixInAnnotations(WebMediaHeadline.class, WebMediaHeadlineMixin.class);

        //--------------------------MEDIA METADATA MIXINS ------------------------------//
        //Article Metadata Mixins
        setupContext.setMixInAnnotations(ArticleMetadata.class, ArticleMetadataMixin.class);
        setupContext.setMixInAnnotations(LedeMetadata.class, LedeMetadataMixin.class);
        setupContext.setMixInAnnotations(SeoMetadata.class, SeoMetadataMixin.class);
        setupContext.setMixInAnnotations(SocialMetadata.class, SocialMetadataMixin.class);

        //--------------------------MEDIA QUOTE MIXINS ------------------------------//
        //Article Media Quote Mixins
        setupContext.setMixInAnnotations(MediaArticleQuote.class, MediaArticleQuoteMixin.class);

        //--------------------------MEDIA TAGS MIXINS ------------------------------//
        //Media Label Mixins
        setupContext.setMixInAnnotations(MediaLabel.class, MediaLabelMixin.class);
        //Media Topic Mixins
        setupContext.setMixInAnnotations(MediaTopic.class, MediaTopicMixin.class);
        //Media Article Tag Mixins
        setupContext.setMixInAnnotations(MediaArticleTags.class, MediaArticleTagMixin.class);

        //--------------------------MEDIA MODULE MIXINS ------------------------------//
        //Article Media Module Mixins
        setupContext.setMixInAnnotations(ArticleMediaModule.class, ArticleMediaModuleMixin.class);
        //Tracker Media Module Mixins
        setupContext.setMixInAnnotations(TrackerMediaModule.class, TrackerMediaModuleMixin.class);


    }
}
