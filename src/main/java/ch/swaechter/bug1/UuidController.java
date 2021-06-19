package ch.swaechter.bug1;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.tags.Tag;

@Controller("/bug1")
@Tag(name = "Bug1")
public class UuidController {

    @Post("/uuid")
    public UuidDto getExampleUuidDto(@Body UuidDto uuidDto) {
        return uuidDto;
    }
}
