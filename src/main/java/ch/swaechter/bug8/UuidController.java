package ch.swaechter.bug8;

import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;

@Controller("/bug8")
@Tag(name = "Bug8")
public class UuidController {

    private static final Logger logger = LoggerFactory.getLogger(UuidController.class);

    @Post("/greeting")
    @Tag(name = "Bug8")
    public void sendGreeting(@Valid @Body Greeting8 greeting) {
        logger.info(greeting.getSenderId() + " is sending the following greeting to " + greeting.getReceiverId() + ": " + greeting.getMessage());
    }
}
