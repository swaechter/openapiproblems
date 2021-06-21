package ch.swaechter.bug5;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.UUID;

@Controller("/bug5")
@Tag(name = "Bug5")
public class OwnerController {

    @Get(value = "/owner")
    public Owner getOwner() {
        Car car = new Car();
        car.setId(UUID.randomUUID());
        car.setName("VW Golf");

        Owner owner = new Owner();
        owner.setName("Joe");
        owner.setVehicle(car);
        return owner;
    }

}
