package com.robzilla.toolrental.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

// TODO:  abstract this out so it will be easy to add other types of rentals in the future
public interface ToolCharge {

    default int calculateRentalCostCents(LocalDate startDate, int numDays, int percentDiscount)
            throws IllegalArgumentException {
        validateNumDays(numDays);
        validatePercentDiscount(percentDiscount);
        LocalDate currentDate = startDate;
        long rentalSumCents = 0;
        // TODO: based on whether to charge for weekends and holidays, determine how many days will NOT
        // be charged and subtract from the total number of days

        // TODO: calculate cost based on actual charged days and discount

        return 0;
    }

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
