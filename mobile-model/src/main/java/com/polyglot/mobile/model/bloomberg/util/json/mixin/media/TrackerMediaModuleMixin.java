package com.polyglot.mobile.model.bloomberg.util.json.mixin.media;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.polyglot.mobile.model.bloomberg.attachment.ArticleMediaAttachment;
import com.polyglot.mobile.model.bloomberg.credits.author.MediaAuthorCredits;
import com.polyglot.mobile.model.bloomberg.headlines.WebMediaHeadline;
import com.polyglot.mobile.model.bloomberg.media.ModuleMediaType;
import com.polyglot.mobile.model.bloomberg.quote.MediaArticleQuote;
import com.polyglot.mobile.model.bloomberg.tags.MediaArticleTags;
import org.joda.time.DateTime;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public abstract class TrackerMediaModuleMixin {

    private ArticleMediaAttachment attachments;
    private MediaAuthorCredits credits;
    private DateTime curatedAt;
    private WebMediaHeadline headlines;
    private DateTime publishedAt;
    private MediaArticleQuote quote;
    private String shortUrl;
    private String slug;
    private String summary;
    private MediaArticleTags tags;
    private String type;
    private DateTime updatedAt;
    private String url;
    private String primarySite;


    @JsonIgnore
    public abstract ModuleMediaType getModuleMediaType();
}
