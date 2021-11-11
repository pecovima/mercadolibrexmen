package com.mercadolibre.adapter.router.controller;

import com.mercadolibre.adapter.router.error.handler.ResponseErrorDTO;
import com.mercadolibre.adapter.router.facade.MutantFacade;
import com.mercadolibre.domain.service.model.request.MutantDTO;
import com.mercadolibre.domain.service.model.response.ResponseMutantDTO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

import static com.mercadolibre.adapter.router.RouterConsts.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(CROSS_ORIGIN)
@RestController
@RequestMapping(path = CONTROLLER_PATH)
@Api(tags = API)
public class MutantRestController {

    @Autowired
    MutantFacade mutantFacade;

    @GetMapping(MAPPING_STATUS)
    public ResponseEntity<String> statusService(){
        String status = String.format(MESSAGE_STATUS, new Date());
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping(value = MAPPING_POST_MUTANT,produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = API_OPERATION_MUTANT, notes = NOTE_API_OPERATION_POST_MUTANT)
    @ApiResponses(value = {@ApiResponse(code = 200, message = API_RESPONSE_COD_200, response = ResponseMutantDTO.class),
            @ApiResponse(code = 400, message = API_RESPONSE_COD_400, response = ResponseErrorDTO.class),
            @ApiResponse(code = 404, message = API_RESPONSE_COD_404, response = ResponseErrorDTO.class),
            @ApiResponse(code = 422, message = API_RESPONSE_COD_422, response = ResponseErrorDTO.class),
            @ApiResponse(code = 500, message = API_RESPONSE_COD_500, response = ResponseErrorDTO.class)})
    public ResponseEntity<Object> isMutant(
            @ApiParam(value = API_PARAM_REQUEST_MS, required = true) @RequestBody(required = true) MutantDTO requestMs){

        return mutantFacade.isMutant(requestMs);
    }

    @GetMapping(value = MAPPING_GET_MUTANT, produces = APPLICATION_JSON_VALUE)
    @ApiOperation(value = API_OPERATION_MUTANT_GET, notes = NOTE_API_OPERATION_GET_MUTANT)
    @ApiResponses(value = {@ApiResponse(code = 200, message = API_RESPONSE_COD_200, response = ResponseMutantDTO.class),
            @ApiResponse(code = 400, message = API_RESPONSE_COD_400, response = ResponseErrorDTO.class),
            @ApiResponse(code = 404, message = API_RESPONSE_COD_404, response = ResponseErrorDTO.class),
            @ApiResponse(code = 422, message = API_RESPONSE_COD_422, response = ResponseErrorDTO.class),
            @ApiResponse(code = 500, message = API_RESPONSE_COD_500, response = ResponseErrorDTO.class)})
    public ResponseEntity<Object> stats() {
        return mutantFacade.stats();
    }
}
