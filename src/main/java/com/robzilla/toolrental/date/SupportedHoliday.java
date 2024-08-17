package com.robzilla.toolrental.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.function.Predicate;

public enum SupportedHoliday {
    // July 4th if on a weekday, otherwise the closest weekday to July 4th.
    INDEPENDENCE_DAY(date -> Month.JULY == date.getMonth() &&
            ( (4 == date.getDayOfMonth() && ! DateUtils.isWeekend(date))
              || ( (3 == date.getDayOfMonth() && DayOfWeek.FRIDAY == date.getDayOfWeek())
                || (5 == date.getDayOfMonth() && DayOfWeek.MONDAY == date.getDayOfWeek())
            ))),
    // Always the first Monday of September.
    LABOR_DAY(date -> Month.SEPTEMBER == date.getMonth() &&
            DayOfWeek.MONDAY == date.getDayOfWeek() &&
            8 > date.getDayOfMonth());

    private final Predicate<LocalDate> isThisDay;

    private SupportedHoliday(Predicate<LocalDate> holidayCheckFunction) {
        isThisDay = holidayCheckFunction;
    }

    private Predicate<LocalDate> getPredicate() {
        return isThisDay;
    }

    public static boolean isHoliday(LocalDate date) throws IllegalArgumentException{
        if (null == date) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        return Arrays.stream(SupportedHoliday.values()).anyMatch(
                holiday -> holiday.getPredicate().test(date));
    }

}
