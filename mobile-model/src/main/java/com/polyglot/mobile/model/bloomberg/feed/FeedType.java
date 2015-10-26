package com.polyglot.mobile.model.bloomberg.feed;

/**
 * Created by Rajiv Singla on 10/25/2015.
 */
public enum FeedType {

    HOMEPAGE("Bloomberg Homepage"),
    POLITICS("Bloomberg Politics");

    private String description;

    private FeedType(final String description) {
        this.description = description;
    }
}
