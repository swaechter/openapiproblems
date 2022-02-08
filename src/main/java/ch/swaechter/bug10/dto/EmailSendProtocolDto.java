package ch.swaechter.bug10.dto;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Schema that represents the possible email protocols for sending emails")
public enum EmailSendProtocolDto {
    SMTP,
    SMTP_SSL,
    SMTP_STARTTLS
}
