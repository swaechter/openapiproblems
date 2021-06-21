package ch.swaechter.bug5;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Introspected
@Schema(description = "Bike, a custom vehicle type")
public class Bike implements Vehicle {

    private UUID id;

    private String name;

    public Bike() {
    }

    @Override
    @Schema(description = "Unique ID of the bike")
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Schema(description = "Name of the bike")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
