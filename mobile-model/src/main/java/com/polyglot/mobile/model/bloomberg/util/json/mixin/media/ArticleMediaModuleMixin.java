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

public abstract class ArticleMediaModuleMixin {

    protected ArticleMediaAttachment attachments;
    protected MediaAuthorCredits credits;
    protected DateTime curatedAt;
    protected WebMediaHeadline headlines;
    protected DateTime publishedAt;
    protected MediaArticleQuote quote;
    protected String shortUrl;
    protected String slug;
    protected String summary;
    protected MediaArticleTags tags;
    protected String type;
    protected DateTime updatedAt;
    protected String url;
    protected String primarySite;


    @JsonIgnore
    public abstract ModuleMediaType getModuleMediaType();

}
