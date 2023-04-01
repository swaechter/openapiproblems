package ch.swaechter.bug11;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema that represents the current backup settings")
public class ReadBackupSettingsDto11 {

    @Schema(description = "Required backup frequency", requiredMode = Schema.RequiredMode.REQUIRED, nullable = false)
    private BackupFrequencyDto11 requiredBackupFrequency;

    @Schema(description = "Optional backup frequency. The key/value be omitted in the JSON result.", requiredMode = Schema.RequiredMode.NOT_REQUIRED, nullable = true)
    private BackupFrequencyDto11 optionalBackupFrequency;

    public ReadBackupSettingsDto11() {
    }

    public BackupFrequencyDto11 getRequiredBackupFrequency() {
        return requiredBackupFrequency;
    }

    public void setRequiredBackupFrequency(BackupFrequencyDto11 requiredBackupFrequency) {
        this.requiredBackupFrequency = requiredBackupFrequency;
    }

    public BackupFrequencyDto11 getOptionalBackupFrequency() {
        return optionalBackupFrequency;
    }

    public void setOptionalBackupFrequency(BackupFrequencyDto11 optionalBackupFrequency) {
        this.optionalBackupFrequency = optionalBackupFrequency;
    }
}
