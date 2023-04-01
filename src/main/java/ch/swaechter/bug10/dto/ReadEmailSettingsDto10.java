package ch.swaechter.bug10.dto;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema that represents the current email settings")
public record ReadEmailSettingsDto10(

        @Schema(description = "Flag that indicates whether the email sending is active or not. If set to false, all other values are null", required = true)
        Boolean active,

        @Schema(description = "Hostname or IP of the email server or null if email sending is disabled", required = true, nullable = true)
        String hostname,

        @Schema(description = "Port of the email server or null if email sending is disabled", required = true, nullable = true)
        Integer port,

        @Schema(description = "Protocol used for the connection or null if email sending is disabled", required = true, nullable = true)
        EmailSendProtocolDto10 protocol,

        @Schema(description = "Email username to login or null if email sending is disabled", required = true, nullable = true)
        String username,

        @Schema(description = "Plaintext password for the email user to login in or null if email sending is disabled", required = true, nullable = true)
        String plaintextPassword,

        @Schema(description = "Sender email address that is used to send emails or null if email sending is disabled", required = true, nullable = true)
        String senderEmail
) {
}
