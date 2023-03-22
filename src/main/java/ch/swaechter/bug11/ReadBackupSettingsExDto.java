package ch.swaechter.bug11;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema that represents the current backup settings")
public class ReadBackupSettingsExDto {

    //@Schema(description = "Required backup frequency", required = true, nullable = false)
    @Schema(description = "Required backup frequency", requiredMode = Schema.RequiredMode.REQUIRED, nullable = false)
    private BackupFrequencyExDto requiredBackupFrequency;

    //@Schema(description = "Optional backup frequency. The key/value be omitted in the JSON result.", required = false, nullable = true)
    @Schema(description = "Optional backup frequency. The key/value be omitted in the JSON result.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, nullable = true)
    private BackupFrequencyExDto optionalBackupFrequency;

    public ReadBackupSettingsExDto() {
    }

    public BackupFrequencyExDto getRequiredBackupFrequency() {
        return requiredBackupFrequency;
    }

    public void setRequiredBackupFrequency(BackupFrequencyExDto requiredBackupFrequency) {
        this.requiredBackupFrequency = requiredBackupFrequency;
    }

    public BackupFrequencyExDto getOptionalBackupFrequency() {
        return optionalBackupFrequency;
    }

    public void setOptionalBackupFrequency(BackupFrequencyExDto optionalBackupFrequency) {
        this.optionalBackupFrequency = optionalBackupFrequency;
    }
}
