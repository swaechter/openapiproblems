package ch.swaechter.bug12;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema to represent a backup")
public record BackupDto12(

        @Schema(description = "Referenced class. $ref shouldn't specify the type of BackupSubObject12")
        BackupSubObject12 location,

        @Schema(description = "Referenced enum. $ref shouldn't specify the type of BackupSubEnum12")
        BackupSubEnum12 state
) {
}
