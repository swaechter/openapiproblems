package ch.swaechter.bug11;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/bug11")
@Tag(name = "Bug11")
public class BackupController {

    @Get("/backup")
    public ReadBackupSettingsExDto getBackupSettings11() {
        ReadBackupSettingsExDto readBackupSettingsDto = new ReadBackupSettingsExDto();
        readBackupSettingsDto.setRequiredBackupFrequency(BackupFrequencyExDto.MONDAY);
        readBackupSettingsDto.setOptionalBackupFrequency(null);
        return readBackupSettingsDto;
    }
}
