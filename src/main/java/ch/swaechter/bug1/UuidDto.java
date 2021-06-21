package ch.swaechter.bug1;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Introspected
@Schema(description = "Schema to show different method/field schemas")
public class UuidDto {

    @Schema(description = "Working UUID")
    private UUID workingUuid;

    private UUID brokenUuid;

    private UuidNestedObject nestedObject;

    public UuidDto() {
    }

    public UuidDto(UUID workingUuid, UUID brokenUuid, UuidNestedObject nestedObject) {
        this.workingUuid = workingUuid;
        this.brokenUuid = brokenUuid;
        this.nestedObject = nestedObject;
    }

    public UUID getWorkingUuid() {
        return workingUuid;
    }

    public void setWorkingUuid(UUID workingUuid) {
        this.workingUuid = workingUuid;
    }

    @Schema(description = "Broken UUID")
    public UUID getBrokenUuid() {
        return brokenUuid;
    }

    public void setBrokenUuid(UUID brokenUuid) {
        this.brokenUuid = brokenUuid;
    }

    public UuidNestedObject getNestedObject() {
        return nestedObject;
    }

    public void setNestedObject(UuidNestedObject nestedObject) {
        this.nestedObject = nestedObject;
    }
}
