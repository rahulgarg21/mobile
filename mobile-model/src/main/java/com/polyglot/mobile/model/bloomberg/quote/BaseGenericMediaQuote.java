package com.polyglot.mobile.model.bloomberg.quote;

import com.polyglot.mobile.model.bloomberg.common.BTextModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public abstract class BaseGenericMediaQuote implements GenericMediaQuote, BTextModel {

    private String text;
    private String credit;
    private Boolean hideOnSingle;

}
