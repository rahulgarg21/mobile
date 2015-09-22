package com.polyglot.mobile.persistence.auditing.impl;

import com.polyglot.mobile.persistence.auditing.DateTimeService;
import org.springframework.data.auditing.DateTimeProvider;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
public class AuditingDateTimeProvider implements DateTimeProvider{

    private final DateTimeService dateTimeService;

    public AuditingDateTimeProvider(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @Override
    public Calendar getNow() {
        return dateTimeService.getCurrentDateAndTime().toCalendar(Locale.getDefault());
    }
}
