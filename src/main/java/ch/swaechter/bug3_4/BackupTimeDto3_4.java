package ch.swaechter.bug3_4;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Introspected
@Schema(description = "Schema represents the backup time in the European time format (E.g. 19:30)")
public class BackupTimeDto3_4 {

    @NotNull
    @Min(0)
    @Max(23)
    private Integer hour;

    @NotNull
    @Min(0)
    @Max(59)
    private Integer minute;

    public BackupTimeDto3_4() {
    }

    public BackupTimeDto3_4(Integer hour, Integer minute) {
        this.hour = hour;
        this.minute = minute;
    }

    @Schema(description = "Hour of the day in the European format (E.g. 19:30)", required = true)
    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    @Schema(description = "Minutes of the hour", required = true)
    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }
}
