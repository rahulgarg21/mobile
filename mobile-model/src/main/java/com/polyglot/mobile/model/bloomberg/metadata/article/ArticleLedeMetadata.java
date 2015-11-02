package com.polyglot.mobile.model.bloomberg.metadata.article;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.metadata.BaseLedeMetadata;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class ArticleLedeMetadata extends BaseLedeMetadata implements BIdModel<Integer> {

    private Integer id;


}
