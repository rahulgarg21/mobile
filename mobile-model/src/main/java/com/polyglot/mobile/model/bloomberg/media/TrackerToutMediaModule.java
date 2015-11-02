package com.polyglot.mobile.model.bloomberg.media;

import com.polyglot.mobile.model.bloomberg.common.BHeadlineModel;
import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.common.BUrlModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/11/2015.
 */
@Data
public class TrackerToutMediaModule implements GenericModuleMedia, BHeadlineModel, BIdModel<String>, BUrlModel {

    private String headline;
    private String id;
    private String type;
    private String url;
    private String toutDek;

}
