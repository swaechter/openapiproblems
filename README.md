# Micronaut OpenAPI Problems

## Idea

This repository contains a collection of several Micronaut bugs and shortcomings. It started after a discussion on Twitter: https://twitter.com/swaechter_ch/status/1406215247120175107

## Bug 1: Some @Schema annotations for object have to be used on fields, others on methods

Some `@Schema` annotation like for `UUID` have to be used on fields (and only fields), but other can only be used on getter methods (**TODO: Look for example**). When used on a getter method, MN thinks it's an object and not a string of format UUID. This can be seen in the POST example:

![](images/Bug1_1.png)

In addition/as a reason of `brokenId`, `UUID` shows up as object under `Schemas` which it shouldn't.

![](images/Bug1_2.png)

Expected result:

* I can use all @Schema annotation on fields or methods (I prefer fields. IMO I think it's more readable. Getter only is ok too, but mixing is bad - we do this at work at the moment and people don't understand the reason).
* `UUID` doesn't show up as type

## Bug 2: @Post endpoint with no parameters generates a wrong object parameter

A `POST` endpoint without a (request? response? request AND response?) body generates an empty request object. Starting a backup via `POST` (Rest terminology: Create a new backup. The backup configuration is known to the backend):

![](images/Bug2_1.png)

This issue is already documented here: https://github.com/micronaut-projects/micronaut-openapi/issues/44 and https://github.com/micronaut-projects/micronaut-openapi/issues/402

Expected result:

* I can trigger the endpoint without a request payload

## Bug 3: Enum types cannot be defined as beans

In earlier MN 2 versions we used enums, e.g. for the frequency of the backup (Weekday or daily). This doesn't work anymore and generates the following error:

![](images/Bug3_1.png)

**Note**: I didn't check the issue tracker for this issue

**Note**: In the example, the `@Schema` annotation for `BackupFrequencyDto` is commented out, so someone can build and run the application. Re-enable the annotation to reproduce the error

Expected result:

* Being able to build the project

## Bug 4: Enum support is broken

Before we encountered bug 3, the generation of enum was broken. It didn't return the possible string values, but was an empty object:

![](images/Bug4_1.png)

![](images/Bug4_2.png)

Some of this behaviour is documented here: https://github.com/micronaut-projects/micronaut-openapi/issues/483 The inheritance issue (See bug 5) was partially fixed, but is still problematic. The enum problem still exists and/or is blocked by bug 3

Expected result:

* Proper enum values like in MN 2.0/2.1/(2.2?)

## Bug 5: Inheritance via anyOf (and other) doesn't work on getter/fields, but only the class

Like mentioned in bug 4 or https://github.com/micronaut-projects/micronaut-openapi/issues/483 , a schema with inheritance like anyOf (Object has to be of type X, Y, Z...) still doesn't work if not annotated on the class. This works for me, but is related to issue1: Where to annotate (Now we have 3 locations to annotate: Field, method, class)

Expected result:

* Being able to annotate the anyOf values on the field or getter-method like in bug 1

## Bug 6: Returning StreamedFile does not change the OpenAPI

See issue https://github.com/micronaut-projects/micronaut-openapi/issues/441

```java
/**
 * Download a specific log file by the file name.
 *
 * @param fileName Name of the log file
 * @return Log file as download
*/
@Get("/logs/files/file")
@Tag(name = "Logs")
@ApiResponse(responseCode = "200", description = "Download of the specific log file", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = "string", format = "binary")))
@ApiResponse(responseCode = "401", description = "Not authenticated")
@ApiResponse(responseCode = "500", description = "Internal server error")
public SystemFile downloadLogFile(@QueryValue String fileName) {
    return logService.downloadLogFileByFileName(fileName);
}
```

**Note**: I didn't check the bug and guess it still exists because the issue is open

## Bug 7: Uploading a file AND returning StreamedFile without OpenAPI generates a 403

See bug 6 - but with one change (See https://github.com/micronaut-projects/micronaut-openapi/issues/441#issuecomment-770386287): I upload a file AND return a file. Use case: Upload a CSV file to generate a PDF report. When the `produce` field is not set, a strange 403 HTTP error is thrown (IMHO even if security is disabled/not included - this was quite misleading and took me some time to understand):

```java
@Post(value = "/signing/file", consumes = MediaType.MULTIPART_FORM_DATA, produces = MediaType.APPLICATION_OCTET_STREAM) // This line is really important, otherwise the 200 annotation will trigger a 403 Forbidden
@Tag(name = "Signing")
@ApiResponse(responseCode = "200", description = "Download the signed file", content = @Content(mediaType = MediaType.APPLICATION_OCTET_STREAM, schema = @Schema(type = "string", format = "binary")))
@ApiResponse(responseCode = "401", description = "Not authenticated")
@ApiResponse(responseCode = "500", description = "Internal server error")
public SystemFile signFile(CompletedFileUpload file) throws ServerException {
    return signingService.signFile(file);
}
```

Expected result:

* The endpoint should be callable even without the Javadoc/OpenAPI doc. We can only call the endpoint AFTER we added the `produces` value

**Note**: I didn't check the bug and guess it still exists because the issue is open

## Bug 8: Custom merged OpenAPI file is not sorted

When defining an additional custom OpenAPI file that is merged into the OpenAPI output, the endpoints/tags are not included into the sorting (Maybe the sorting is done earlier in the process). We describe the `/login` JWT endpoint via tag `Authentication` and the tag lands at the end.

This is not really a problem (more a nitpick), but annoying for OpenAPI users that are used to the alphabetical order of the tags:

Expected result:

* All tags, even manually merged ones, are alphabetically sorted

![](images/Bug8_1.png)

## Bug 9 & 10: TODO

Bugs I need to check at work


## Other bugs

There are a few other bugs I encountered during my bachelor thesis that made the developer experience harder:

### Non OpenAPI related bug: 

Not OpenAPI related, but **a really dangerous API misunderstanding that can lead to data corruption**: https://github.com/micronaut-projects/micronaut-core/issues/2836
