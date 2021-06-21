package ch.swaechter.bug7;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.multipart.CompletedFileUpload;
import io.micronaut.http.server.types.files.SystemFile;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.io.File;
import java.io.FileOutputStream;

@Controller("/bug7")
@Tag(name = "Bug7")
public class UploadController {

    // The produces is really important, otherwise we can't trigger the endpoint. It will produce an error
    //@Post(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.APPLICATION_OCTET_STREAM)
    @Post(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA)
    @Tag(name = "Bug7")
    @ApiResponse(responseCode = "200", description = "Download the same file again", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = "string", format = "binary")))
    @ApiResponse(responseCode = "500", description = "Internal server error")
    public SystemFile redownloadFile(CompletedFileUpload file) throws Exception {
        File temporaryFile = File.createTempFile("micronaut", "openapiproblems");
        try (FileOutputStream outputStream = new FileOutputStream(temporaryFile)) {
            outputStream.write(file.getBytes());
        }
        return new SystemFile(temporaryFile, MediaType.APPLICATION_OCTET_STREAM_TYPE).attach(file.getFilename());
    }
}
