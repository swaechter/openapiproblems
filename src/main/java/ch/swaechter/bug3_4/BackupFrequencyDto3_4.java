package ch.swaechter.bug3_4;

import io.micronaut.core.annotation.Introspected;

@Introspected
// Please re-enable to generate the error
//@Schema(description = "Schema that represents the frequency of the backup")
// Please re-enable to generate the error
public enum BackupFrequencyDto3_4 {
    DAILY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
