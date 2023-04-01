package ch.swaechter.bug10.dto;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema that represents an existing email output location")
public record ReadEmailOutputLocationDto10(

        // Snipped a lot of attributes. Class doesn't make any sense for outstanders

        @Schema(description = "Protocol used for the connection", required = true)
        EmailSendProtocolDto10 protocol
) {
}
