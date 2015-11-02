package com.polyglot.mobile.model.bloomberg.credits.author;

import com.polyglot.mobile.model.bloomberg.common.BIdModel;
import com.polyglot.mobile.model.bloomberg.common.BSlugModel;
import lombok.Data;

/**
 * Created by Rajiv Singla on 11/1/2015.
 */
@Data
public class MediaAuthor implements BIdModel<String>, BSlugModel<String> {

    private String fullName;
    private String id;
    private String slug;

}
