package ch.swaechter.bug10;

import ch.swaechter.bug10.dto.ReadEmailOutputLocationDto;
import ch.swaechter.bug10.dto.ReadEmailSettingsDto;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * Manage the email settings.
 *
 * @author Simon Wächter
 */
@Controller("/api")
@Validated
public class EmailController {

    /**
     * Get the email settings.
     *
     * @return Email settings
     * @throws Exception Exception in case of invalid data or an issue with reading the settings
     */
    @Get("/email/settings")
    @Tag(name = "Email")
    @Operation(operationId = "getEmailSettings")
    @ApiResponse(responseCode = "200", description = "Email settings")
    @ApiResponse(responseCode = "401", description = "Not authenticated")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ReadEmailSettingsDto getEmailSettings() throws Exception {
        return null;
    }

    /**
     * Get the email output location.
     *
     * @return Email output location
     * @throws Exception Exception in case of invalid data or an issue with reading the settings
     */
    @Get("/email/output")
    @Tag(name = "Email")
    @Operation(operationId = "getEmailOutputLocation")
    @ApiResponse(responseCode = "200", description = "Email output location")
    @ApiResponse(responseCode = "401", description = "Not authenticated")
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public ReadEmailOutputLocationDto getEmailOutputLocation() throws Exception {
        return null;
    }
}
