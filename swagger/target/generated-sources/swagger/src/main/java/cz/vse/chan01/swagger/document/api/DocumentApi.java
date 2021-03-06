/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package cz.vse.chan01.swagger.document.api;

import cz.vse.chan01.swagger.document.model.Document;
import cz.vse.chan01.swagger.document.model.VersionedDocument;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-03-11T17:13:58.360+01:00")

@Api(value = "document", description = "the document API")
public interface DocumentApi {

    Logger log = LoggerFactory.getLogger(DocumentApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Find document by ID", nickname = "documentById", notes = "Returns a single document", response = Document.class, tags={ "document", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "document found", response = Document.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "document not found") })
    @RequestMapping(value = "/document/{documentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Document> documentById(@ApiParam(value = "ID of document to return",required=true) @PathVariable("documentId") String documentId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"archivationDate\" : \"2000-01-23\",  \"versions\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"format\" : \"PDF\",    \"version\" : \"version\",    \"versionedDocumentId\" : \"versionedDocumentId\",    \"content\" : \"content\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"format\" : \"PDF\",    \"version\" : \"version\",    \"versionedDocumentId\" : \"versionedDocumentId\",    \"content\" : \"content\"  } ],  \"caseId\" : 0,  \"customerId\" : 6,  \"name\" : \"name\",  \"documentId\" : \"documentId\",  \"documentStatus\" : \"CREATED\",  \"creationDate\" : \"2000-01-23\"}", Document.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DocumentApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Find all documents", nickname = "documents", notes = "Returns list of documents", response = Document.class, responseContainer = "List", tags={ "document", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "documents found", response = Document.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "No document found") })
    @RequestMapping(value = "/document",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Document>> documents(@ApiParam(value = "Find documents by caseId") @Valid @RequestParam(value = "caseId", required = false) Optional<Long> caseId,@ApiParam(value = "Find documents by customerId") @Valid @RequestParam(value = "customerId", required = false) Optional<Long> customerId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"archivationDate\" : \"2000-01-23\",  \"versions\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"format\" : \"PDF\",    \"version\" : \"version\",    \"versionedDocumentId\" : \"versionedDocumentId\",    \"content\" : \"content\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"format\" : \"PDF\",    \"version\" : \"version\",    \"versionedDocumentId\" : \"versionedDocumentId\",    \"content\" : \"content\"  } ],  \"caseId\" : 0,  \"customerId\" : 6,  \"name\" : \"name\",  \"documentId\" : \"documentId\",  \"documentStatus\" : \"CREATED\",  \"creationDate\" : \"2000-01-23\"}, {  \"archivationDate\" : \"2000-01-23\",  \"versions\" : [ {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"format\" : \"PDF\",    \"version\" : \"version\",    \"versionedDocumentId\" : \"versionedDocumentId\",    \"content\" : \"content\"  }, {    \"date\" : \"2000-01-23T04:56:07.000+00:00\",    \"format\" : \"PDF\",    \"version\" : \"version\",    \"versionedDocumentId\" : \"versionedDocumentId\",    \"content\" : \"content\"  } ],  \"caseId\" : 0,  \"customerId\" : 6,  \"name\" : \"name\",  \"documentId\" : \"documentId\",  \"documentStatus\" : \"CREATED\",  \"creationDate\" : \"2000-01-23\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DocumentApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Creates a document", nickname = "postDocument", notes = "Creates a document", tags={ "document", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created") })
    @RequestMapping(value = "/document",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> postDocument(@ApiParam(value = "The document to create."  )  @Valid @RequestBody Document document) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DocumentApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Creates a versioned document", nickname = "postDocumentVersion", notes = "Creates a versioned document", tags={ "document", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created") })
    @RequestMapping(value = "/document/{documentId}/version",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> postDocumentVersion(@ApiParam(value = "ID of document to return",required=true) @PathVariable("documentId") String documentId,@ApiParam(value = "The versioned document to create."  )  @Valid @RequestBody VersionedDocument versionedDocument) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DocumentApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Find versioned document by ID", nickname = "versionedDocumentById", notes = "Returns list of versioned documents", response = VersionedDocument.class, tags={ "document", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "documents found", response = VersionedDocument.class) })
    @RequestMapping(value = "/document/{documentId}/version/{versionedDocumentId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<VersionedDocument> versionedDocumentById(@ApiParam(value = "ID of document to return",required=true) @PathVariable("documentId") String documentId,@ApiParam(value = "ID of versioned document to return",required=true) @PathVariable("versionedDocumentId") String versionedDocumentId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"date\" : \"2000-01-23T04:56:07.000+00:00\",  \"format\" : \"PDF\",  \"version\" : \"version\",  \"versionedDocumentId\" : \"versionedDocumentId\",  \"content\" : \"content\"}", VersionedDocument.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default DocumentApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
