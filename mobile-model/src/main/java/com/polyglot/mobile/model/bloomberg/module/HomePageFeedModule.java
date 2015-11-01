package com.polyglot.mobile.model.bloomberg.module;

import com.polyglot.mobile.model.bloomberg.media.ModuleMedia;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class HomepageFeedModule<M extends ModuleMedia> extends BaseGenericFeedModule<M> {

    private int size;
    private String heroType;

    public int getSize() {
        return size;
    }

    public String getHeroType() {
        return heroType;
    }

}
