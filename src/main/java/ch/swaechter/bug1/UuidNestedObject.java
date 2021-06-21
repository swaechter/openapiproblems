package ch.swaechter.bug1;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Nested object")
public class UuidNestedObject {

    @Schema(description = "Example value")
    private String value;

    public UuidNestedObject() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
