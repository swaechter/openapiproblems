package ch.swaechter.bug9;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

@Controller("/bug9")
@Tag(name = "Bug9")
public class UuidController {

    /**
     * Return a friendly greeting.
     *
     * @return A friendly greeting
     */
    @Get("/greeting")
    @Tag(name = "Bug9")
    @ApiResponse(responseCode = "200", description = "A friendly greeting")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public Greeting getGreeting() {
        return new Greeting("A friendly greeting!", UUID.randomUUID(), UUID.randomUUID());
    }
}
