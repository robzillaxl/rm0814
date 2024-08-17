package com.robzilla.toolrental.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class DateUtilsTest {

    private static final LocalDate A_MONDAY = LocalDate.of(2024,1, 1);
    private static final LocalDate A_SATURDAY = LocalDate.of(2024,1, 6);

    @Test
    void testWeekdays() {
        LocalDate aDate;
        for (int i = 0; i < 5; i++) {
            aDate = A_MONDAY.plusDays(i);
            assertTrue(DateUtils.isWeekday(aDate));
            assertFalse(DateUtils.isWeekend(aDate));
        }
    }

    @Test
    void testWeekendDays() {
        assertTrue(DateUtils.isWeekend(A_SATURDAY));
        assertFalse(DateUtils.isWeekday(A_SATURDAY));
        assertTrue(DateUtils.isWeekend(A_SATURDAY.plusDays(1)));
        assertFalse(DateUtils.isWeekday(A_SATURDAY.plusDays(1)));
    }


}