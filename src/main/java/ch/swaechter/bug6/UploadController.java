package ch.swaechter.bug6;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.types.files.SystemFile;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.io.File;
import java.io.FileOutputStream;

@Controller("/bug6")
@Tag(name = "Bug6")
public class UploadController {

    @Get(value = "/file")
    @Tag(name = "Bug6")
    @ApiResponse(responseCode = "200", description = "Download the same file again")
    // Comment in the following line to create proper OpenAPI
    //@ApiResponse(responseCode = "200", description = "Download the same file again", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = "string", format = "binary")))
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public SystemFile downloadWaterFile() throws Exception {
        File temporaryFile = File.createTempFile("micronaut", "openapiproblems");
        try (FileOutputStream outputStream = new FileOutputStream(temporaryFile)) {
            outputStream.write("Drink more water!".getBytes());
        }
        return new SystemFile(temporaryFile, MediaType.APPLICATION_OCTET_STREAM_TYPE).attach("DrinkMoreWater.txt");
    }
}
