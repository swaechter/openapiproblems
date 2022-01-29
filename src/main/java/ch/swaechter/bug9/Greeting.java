package ch.swaechter.bug9;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Introspected
@Schema(description = "Represent a greeting between a sender and a receiver")
public class Greeting {

    @Schema(description = "Greeting message the receiver will get")
    private String message;

    @Schema(description = "ID of the sender")
    private UUID senderId;

    // Schema is annotated on the getter method bellow
    private UUID receiverId;

    public Greeting() {
    }

    public Greeting(String message, UUID senderId, UUID receiverId) {
        this.message = message;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public void setSenderId(UUID senderId) {
        this.senderId = senderId;
    }

    @Schema(description = "ID of the receiver")
    public UUID getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(UUID receiverId) {
        this.receiverId = receiverId;
    }
}
