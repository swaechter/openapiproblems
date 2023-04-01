package ch.swaechter.bug3_4;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema that represents the current backup settings")
public class ReadBackupSettingsDto3_4 {

    private Boolean active;

    private BackupFrequencyDto3_4 backupFrequency;

    private BackupTimeDto3_4 backupTime;

    private String username;

    private String plaintextPassword;

    private String domain;

    private String uncPath;

    public ReadBackupSettingsDto3_4() {
    }

    @Schema(description = "Flag that indicates whether the backup is active or not. If set to false, all other values are null")
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Schema(description = "Backup frequency (Daily or on a specific weekday) or null if backup is not active")
    public BackupFrequencyDto3_4 getBackupFrequency() {
        return backupFrequency;
    }

    public void setBackupFrequency(BackupFrequencyDto3_4 backupFrequency) {
        this.backupFrequency = backupFrequency;
    }

    @Schema(description = "Backup time in European format (E.g. 19:30) or null if backup is not active")
    public BackupTimeDto3_4 getBackupTime() {
        return backupTime;
    }

    public void setBackupTime(BackupTimeDto3_4 backupTimeDto) {
        this.backupTime = backupTimeDto;
    }

    @Schema(description = "Username for the SMB backup share or null if backup is not active")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Schema(description = "Plaintext password for the user for the SMB backup share or null if backup is not active")
    public String getPlaintextPassword() {
        return plaintextPassword;
    }

    public void setPlaintextPassword(String plaintextPassword) {
        this.plaintextPassword = plaintextPassword;
    }

    @Schema(description = "Optional domain of the user for the SMB backup share and/or null if backup is not active")
    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    @Schema(description = "UNC formatted backup path or null if backup is not active. The backup will be saved into the directory")
    public String getUncPath() {
        return uncPath;
    }

    public void setUncPath(String uncPath) {
        this.uncPath = uncPath;
    }
}
