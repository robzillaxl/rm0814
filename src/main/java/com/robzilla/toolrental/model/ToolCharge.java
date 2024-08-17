package com.robzilla.toolrental.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public interface ToolCharge {

    default int calculateRentalCostCents(LocalDate startDate, int numDays, int percentDiscount)
            throws IllegalArgumentException {
        validateNumDays(numDays);
        validatePercentDiscount(percentDiscount);
        LocalDate currentDate = startDate;
        long rentalSumCents = 0;

        return 0;
    };

    default void validateNumDays(int numDays) throws IllegalArgumentException {
        if (numDays < 1) {
            throw new IllegalArgumentException("The number of rental days, " + numDays + ", is not a positive value.");
        }
    }

    default void validatePercentDiscount(int percentDiscount) {
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("The discount percentage, " + percentDiscount
                    + ", is not within the acceptable range (0 - 100).");
        }
    }


    Tool.ToolType toolType();
    int dailyChargeCents();
    boolean chargeOnWeekdays();
    boolean chargeOnWeekends();
    boolean chargeOnHolidays();

}
