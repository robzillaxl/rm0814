package com.robzilla.toolrental.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SupportedHolidayTest {

  private enum TestHoliday {
    JULY_4TH_ON_A_WEEKDAY(LocalDate.of(2024,7,4)),
    JULY_4TH_ON_A_SATURDAY(LocalDate.of(2026,7,3)),
    JULY_4TH_ON_A_SUNDAY(LocalDate.of(2027,7,5)),
    LABOR_DAY(LocalDate.of(2024,9,2));
    private final LocalDate date;

    TestHoliday(LocalDate date) {
      this.date = date;
    }

    public LocalDate getDate() {
      return date;
    }
  }

  private static final LocalDate NOT_A_HOLIDAY;

  static {
    LocalDate aDay = LocalDate.of(2024,1,2);
    while (SupportedHoliday.isHoliday(aDay)) {
      aDay = aDay.plusDays(1);
    }
    NOT_A_HOLIDAY = aDay;
  }

  @Test
  void testAllHolidays() {
    for (TestHoliday holiday : TestHoliday.values()) {
      assertTrue(SupportedHoliday.isHoliday(holiday.getDate()), holiday.getDate() + " is not a holiday.");
    }
  }

  @Test
  void testNonHoliday() {
    assertFalse(SupportedHoliday.isHoliday(NOT_A_HOLIDAY), NOT_A_HOLIDAY + " has been tagged as a holiday.");
  }

  @Test
  void nullDateTest() {
    assertThrows(IllegalArgumentException.class, () -> SupportedHoliday.isHoliday(null));
  }

}
