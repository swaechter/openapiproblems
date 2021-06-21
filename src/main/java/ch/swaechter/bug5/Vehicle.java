package ch.swaechter.bug5;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

@Schema(description = "A vehicle that represents a car or bike")
//@Schema(description = "A vehicle that represents a car or bike", oneOf = {Car.class, Bike.class})
public interface Vehicle {

    @Schema(description = "Get the unique ID of a vehicle")
    UUID getId();

    void setId(UUID id);
}
