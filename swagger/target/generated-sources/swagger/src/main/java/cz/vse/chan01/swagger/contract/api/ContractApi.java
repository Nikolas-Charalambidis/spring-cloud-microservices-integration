/**
 * NOTE: This class is auto generated by the swagger code generator program (2.4.8).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package cz.vse.chan01.swagger.contract.api;

import cz.vse.chan01.swagger.contract.model.Contract;
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
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-02-06T23:25:03.098+01:00")

@Api(value = "contract", description = "the contract API")
public interface ContractApi {

    Logger log = LoggerFactory.getLogger(ContractApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @ApiOperation(value = "Find contract by ID", nickname = "contractById", notes = "Returns a single contract", response = Contract.class, tags={ "contract", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "contract found", response = Contract.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied"),
        @ApiResponse(code = 404, message = "contract not found") })
    @RequestMapping(value = "/contract/{contractId}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<Contract> contractById(@ApiParam(value = "ID of contract to return",required=true) @PathVariable("contractId") Long contractId) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("{  \"customerLabel\" : \"customerLabel\",  \"contractStatus\" : \"NEW\",  \"contractType\" : \"A\",  \"contractId\" : 0,  \"customerId\" : 6,  \"creationDate\" : \"2000-01-23\",  \"fileId\" : 1,  \"expirationDate\" : \"2000-01-23\"}", Contract.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ContractApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Find all contracts", nickname = "contracts", notes = "Returns list of contracts", response = Contract.class, responseContainer = "List", tags={ "contract", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "contracts found", response = Contract.class, responseContainer = "List"),
        @ApiResponse(code = 404, message = "No contract found") })
    @RequestMapping(value = "/contract",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    default ResponseEntity<List<Contract>> contracts() {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {  \"customerLabel\" : \"customerLabel\",  \"contractStatus\" : \"NEW\",  \"contractType\" : \"A\",  \"contractId\" : 0,  \"customerId\" : 6,  \"creationDate\" : \"2000-01-23\",  \"fileId\" : 1,  \"expirationDate\" : \"2000-01-23\"}, {  \"customerLabel\" : \"customerLabel\",  \"contractStatus\" : \"NEW\",  \"contractType\" : \"A\",  \"contractId\" : 0,  \"customerId\" : 6,  \"creationDate\" : \"2000-01-23\",  \"fileId\" : 1,  \"expirationDate\" : \"2000-01-23\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ContractApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "Creates a contract", nickname = "postContract", notes = "Creates a contract", tags={ "contract", })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Created") })
    @RequestMapping(value = "/contract",
        produces = { "application/json" }, 
        consumes = { "application/json" },
        method = RequestMethod.POST)
    default ResponseEntity<Void> postContract(@ApiParam(value = "The contract to create."  )  @Valid @RequestBody Contract contract) {
        if(getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default ContractApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
