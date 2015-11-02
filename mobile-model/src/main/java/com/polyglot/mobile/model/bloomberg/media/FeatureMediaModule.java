package com.polyglot.mobile.model.bloomberg.media;

import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class FeatureMediaModule extends ArticleMediaModule {

    public ModuleMediaType getModuleMediaType() {
        assert (type.equals(ModuleMediaType.FEATURE.getDescription()));
        return ModuleMediaType.FEATURE;
    }

}
