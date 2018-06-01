package com.lecturer.lecturer4.androidos.helper;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

/**
 * Created by ASUS on 5/22/2018.
 */

public class DateConverter {
    @TypeConverter
    public static Date toDate(Long timestamp) {
        return timestamp == null ? null : new Date(timestamp);
    }

    @TypeConverter
    public static Long toTimestamp(Date date) {
        return date == null ? null : date.getTime();
    }
}
