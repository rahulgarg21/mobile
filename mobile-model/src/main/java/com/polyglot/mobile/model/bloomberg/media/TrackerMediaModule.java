package com.polyglot.mobile.model.bloomberg.media;

import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class TrackerMediaModule extends ArticleMediaModule {

    public ModuleMediaType getModuleMediaType() {
        assert (type.equals(ModuleMediaType.TRACKER.getDescription()));
        return ModuleMediaType.TRACKER;
    }

}
