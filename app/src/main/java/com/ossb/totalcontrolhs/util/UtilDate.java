package com.ossb.totalcontrolhs.util;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by batista on 15/05/16.
 */
public class UtilDate {

    public static final String LOGTAG="UTILDATE";

    /**
     * Get actual date and format it to format passed, them return a date to
     * type String
     * Pattern: Ansi(yyyy-MM-dd HH:mm:ss), This is a Database Pattern
     * Pattern: British(dd-MM-yyyy HH:mm:ss), This is Brazilian Pattern
     *
     * @param format
     * @return (String Date)
     */
    public String getActualDateToString(String format) {
        java.util.Date today = new java.util.Date();
        SimpleDateFormat form = new SimpleDateFormat(format);
        return (form.format(today));
    }

    /**
     * Get a new date to format passed, them format and return it.
     *
     * @param format
     * @return (Date to type Date)
     */
    public java.util.Date getActualDateToDate(String format) {
        java.util.Date today = new java.util.Date();
        SimpleDateFormat form = new SimpleDateFormat(format);

        java.util.Date actual_date = null;//String para data
        try {
            actual_date = (java.util.Date) form.parse(form.format(today));
        } catch (ParseException ex) {
            Log.e(LOGTAG, UtilDate.class.getName(), ex);
        }
        return actual_date;
    }
}
