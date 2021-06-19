package ch.swaechter.bug3_4;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/bug3")
@Tag(name = "Bug3")
public class BackupController {

    @Get("/backup")
    public ReadBackupSettingsDto getBackupSettings() {
        ReadBackupSettingsDto readBackupSettingsDto = new ReadBackupSettingsDto();
        readBackupSettingsDto.setActive(true);
        readBackupSettingsDto.setBackupFrequency(BackupFrequencyDto.DAILY);
        readBackupSettingsDto.setBackupTime(new BackupTimeDto(20, 15));
        readBackupSettingsDto.setUsername("foobar");
        readBackupSettingsDto.setPlaintextPassword("muchsecurepw");
        readBackupSettingsDto.setDomain("acme");
        readBackupSettingsDto.setUncPath("Local");
        return readBackupSettingsDto;
    }
}
