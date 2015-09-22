package com.polyglot.mobile.persistence.auditing.impl;

import com.polyglot.mobile.persistence.auditing.DateTimeService;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
public class DateTimeServiceImpl implements DateTimeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DateTimeServiceImpl.class);

    @Override
    public DateTime getCurrentDateAndTime() {
        final DateTime currentDateTime = DateTime.now();
        LOGGER.debug("Returning current Date and Time: {}", currentDateTime);
        return currentDateTime;
    }
}
