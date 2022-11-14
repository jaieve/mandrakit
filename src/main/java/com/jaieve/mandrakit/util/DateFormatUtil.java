package com.jaieve.mandrakit.util;

import java.text.SimpleDateFormat;

public class DateFormatUtil {
    public String getSimpleDateStr(Long millis) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYY-MM-DD HH://:ss");
        return simpleDateFormat.format(millis);
    }
}
