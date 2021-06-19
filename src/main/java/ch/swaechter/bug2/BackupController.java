package ch.swaechter.bug2;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/bug2")
@Tag(name = "Bug2")
public class BackupController {

    @Post("/backup")
    public void startBackup() {
    }
}
