package ch.swaechter.bug11;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/bug11")
@Tag(name = "Bug11")
public class BackupController {

    @Get("/backup")
    public ReadBackupSettingsDto11 getBackupSettings11() {
        ReadBackupSettingsDto11 readBackupSettingsDto = new ReadBackupSettingsDto11();
        readBackupSettingsDto.setRequiredBackupFrequency(BackupFrequencyDto11.MONDAY);
        readBackupSettingsDto.setOptionalBackupFrequency(null);
        return readBackupSettingsDto;
    }
}
