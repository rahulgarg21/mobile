package com.polyglot.mobile.model.bloomberg.media;

import com.polyglot.mobile.model.bloomberg.metadata.article.ArticleMetadata;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class ArticleMediaModule extends BaseArticleMediaModule {

    protected ArticleMetadata metadata;

    public ModuleMediaType getModuleMediaType() {
        assert (type.equals(ModuleMediaType.ARTICLE.getDescription()));
        return ModuleMediaType.ARTICLE;
    }

}
