package ch.swaechter.bug12;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema to describe the backup location")
public record BackupSubObject12(

        @Schema(description = "Location of the backup")
        String backupLocation
) {
}
