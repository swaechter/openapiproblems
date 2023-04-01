package ch.swaechter.bug12;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "State of the backup")
public enum BackupSubEnum12 {
    WORKING,
    FAILED
}
