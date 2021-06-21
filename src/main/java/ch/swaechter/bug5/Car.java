package ch.swaechter.bug5;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Introspected
@Schema(description = "Car, a custom vehicle type")
public class Car implements Vehicle {

    private UUID id;

    private String name;

    public Car() {
    }

    @Override
    @Schema(description = "Unique ID of the car")
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    @Schema(description = "Name of the car")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
