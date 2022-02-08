package ch.swaechter.bug10.dto;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Introspected
@Schema(description = "Schema that represents an existing email output location")
public record ReadEmailOutputLocationDto(

        // Snipped a lot of attributes. Class doesn't make any sense for outstanders

        @Schema(description = "Protocol used for the connection", required = true)
        EmailSendProtocolDto protocol
) {
}
