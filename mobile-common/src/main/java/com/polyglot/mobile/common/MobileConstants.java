package com.polyglot.mobile.common;

/**
 * Created by Rajiv Singla on 10/7/2015.
 */
public class MobileConstants {

    public static final AppEnvironment DEFAULT_PROPS_ENVIRONMENT = AppEnvironment.COMMON;

    public static final Long PROPS_CACHE_DURATION_SECONDS = 60 * 60 * 12l;

    public static final String PROPS_QUERY_STRING =
            " SELECT AE.APP_ENVIRONMENT_NAME , AP.APP_PROPERTY_KEY  , AP.APP_PROPERTY_VALUE  " +
                    " FROM CONFIG.APP_PROPERTIES AP " +
                    " JOIN CONFIG.APP_ENVIRONMENT AE ON AE.APP_ENVIRONMENT_ID  = AP.APP_ENVIRONMENT_ID " +
                    " ORDER BY AP.APP_PROPERTY_KEY";

    public static final String JMX_PREFIX = "Mobile:name";


}
