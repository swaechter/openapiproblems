package ch.swaechter.bug5;

import io.micronaut.core.annotation.Introspected;
import io.swagger.v3.oas.annotations.media.Schema;

@Introspected
@Schema(description = "Owner that has a vehicle (Car or bike)")
public class Owner {

    @Schema(description = "Name of the owner")
    private String name;

    @Schema(description = "Vehicle of the owner", anyOf = {Car.class, Bike.class})
    private Vehicle vehicle;

    public Owner() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
