package com.robzilla.toolrental.model;

import org.springframework.lang.NonNull;

public record RentalTool(@NonNull Tool.ToolType toolType,
                         int dailyChargeCents,
                         boolean chargeOnWeekdays,
                         boolean chargeOnWeekends,
                         boolean chargeOnHolidays) implements ToolCharge {
}
