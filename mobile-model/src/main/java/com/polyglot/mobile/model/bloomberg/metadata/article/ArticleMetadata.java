package com.polyglot.mobile.model.bloomberg.metadata.article;

import com.polyglot.mobile.model.bloomberg.metadata.BaseGenericMediaMetadata;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class ArticleMetadata extends BaseGenericMediaMetadata {

    private ArticleLedeMetadata lede;

}
