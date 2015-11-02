package com.polyglot.mobile.model.bloomberg.util.json.mixin.module;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.polyglot.mobile.model.bloomberg.module.SimpleFeedModule;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "@type",
        defaultImpl = SimpleFeedModule.class)
public abstract class FeedModuleMixin {
}
