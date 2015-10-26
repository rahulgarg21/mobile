package com.polyglot.mobile.model.bloomberg.common;

import org.joda.time.DateTime;

/**
 * Model which are aware of Update Timings
 *
 * Created by Rajiv Singla on 10/25/2015.
 */
public interface BUpdatedAtModel extends BModel {

    public DateTime getUpdatedAt();

}
