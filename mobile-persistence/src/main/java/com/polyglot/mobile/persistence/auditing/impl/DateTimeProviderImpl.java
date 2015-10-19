package com.polyglot.mobile.persistence.auditing.impl;

import org.joda.time.DateTime;
import org.springframework.data.auditing.DateTimeProvider;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Rajiv Singla on 9/20/2015.
 */
public class DateTimeProviderImpl implements DateTimeProvider {

    @Override
    public Calendar getNow() {
        return DateTime.now().toCalendar(Locale.getDefault());
    }
}
