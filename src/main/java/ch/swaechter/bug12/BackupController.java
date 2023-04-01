package ch.swaechter.bug12;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/bug12")
@Tag(name = "Bug12")
public class BackupController {

    @Get("/backup")
    public BackupDto12 getBackup() {
        return new BackupDto12(new BackupSubObject12("somewhere"), BackupSubEnum12.WORKING);
    }
}
