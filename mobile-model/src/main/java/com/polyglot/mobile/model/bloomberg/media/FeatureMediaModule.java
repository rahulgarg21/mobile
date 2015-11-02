package com.polyglot.mobile.model.bloomberg.media;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
public class FeatureMediaModule extends ArticleMediaModule {

    public ModuleMediaType getModuleMediaType() {
        assert (type.equals(ModuleMediaType.FEATURE.getDescription()));
        return ModuleMediaType.FEATURE;
    }

}
