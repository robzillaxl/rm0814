package com.robzilla.toolrental.date;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class DateUtils {

    public static boolean isWeekday(LocalDate date) {
        return ! isWeekend(date);
    }

    public static boolean isWeekend(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        return DayOfWeek.SATURDAY == dayOfWeek || DayOfWeek.SUNDAY == dayOfWeek;
    }

}
