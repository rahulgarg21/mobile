package com.polyglot.mobile.model.bloomberg.tags.topics;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.common.BNameModel;
import com.polyglot.mobile.model.bloomberg.common.BScoreModel;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class MediaTopic implements BIdModel<String>, BNameModel, BScoreModel<BigDecimal> {

    private String id;
    private String name;
    private BigDecimal score;

}
