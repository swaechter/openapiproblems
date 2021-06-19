package ch.swaechter.bug3_4;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
// Please re-enable to generate the error
//@Schema(description = "Schema that represents the frequency of the backup")
// Please re-enable to generate the error
public enum BackupFrequencyDto {
    DAILY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
