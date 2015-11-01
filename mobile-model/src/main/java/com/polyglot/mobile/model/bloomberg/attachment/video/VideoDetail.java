package com.polyglot.mobile.model.bloomberg.attachment.video;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.common.BShortUrlModel;
import com.polyglot.mobile.model.bloomberg.common.BUrlModel;
import lombok.Data;

import java.util.List;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class VideoDetail implements BIdModel<String>, BUrlModel, BShortUrlModel {

    private List<String> avmm_ids;
    private String id;
    private String bmmrId;
    private String url;
    private String shortUrl;
    private String suid;
    private Thumbnail thumbnail;

}
