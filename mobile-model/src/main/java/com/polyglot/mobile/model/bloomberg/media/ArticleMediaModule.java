package com.polyglot.mobile.model.bloomberg.media;

import com.polyglot.mobile.model.bloomberg.attachment.ArticleMediaAttachment;
import com.polyglot.mobile.model.bloomberg.common.*;
import com.polyglot.mobile.model.bloomberg.credits.author.MediaAuthorCredits;
import com.polyglot.mobile.model.bloomberg.headlines.WebMediaHeadline;
import com.polyglot.mobile.model.bloomberg.metadata.article.ArticleMetadata;
import com.polyglot.mobile.model.bloomberg.quote.MediaArticleQuote;
import com.polyglot.mobile.model.bloomberg.tags.MediaArticleTags;
import lombok.Data;
import org.joda.time.DateTime;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class ArticleMediaModule extends BaseGenericModuleMedia implements BCuratedAtModel,
        BPublishedAtModel, BShortUrlModel, BSlugModel<String>,
        BSummaryModel, BUpdatedAtModel, BUrlModel, BHeadlineModel, BIdModel<String> {

    protected ArticleMediaAttachment attachments;
    protected MediaAuthorCredits credits;
    protected DateTime curatedAt;
    protected String headline;
    protected WebMediaHeadline headlines;
    protected String id;
    protected ArticleMetadata metadata;
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

    public ModuleMediaType getModuleMediaType() {
        assert (type.equals(ModuleMediaType.ARTICLE.getDescription()));
        return ModuleMediaType.ARTICLE;
    }

}
