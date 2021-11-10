package com.mercadolibre.adapter.router.error.handler;

import com.google.gson.Gson;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.*;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.mercadolibre.adapter.router.error.ErrorConsts.ERROR_PARAMETROS_CABECERA;

/**
 * Esta clase se encarga se centralizar los handler según los errores que puedan presentarse
 *
 * @author Victor Perez
 */
public class ErrorHandler extends ResponseEntityExceptionHandler {

    @InitBinder
    private void initBinder(WebDataBinder dataBinder){ dataBinder.initDirectFieldAccess();}

    /**
     * Este método se encarga de controlar los errores que ocurran por medio del @Validated
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request){
        List<Map<String,String>> errores = ex.getBindingResult().getFieldErrors().stream().map(x -> {
            Map<String,String> error = new LinkedHashMap<>();
            error.put(x.getField(), x.getDefaultMessage());
            return error;
        }).collect(Collectors.toList());

        ResponseErrorDTO errorMesage = new ResponseErrorDTO(
                Integer.toString(status.value()),
                new Gson().toJson(errores)
        );

        return new ResponseEntity<>(errorMesage,headers,status);
    }

    @Override
    protected ResponseEntity<Object> handleServletRequestBindingException(ServletRequestBindingException ex,
                                                                          HttpHeaders headers, HttpStatus status,
                                                                          WebRequest request){
        ResponseErrorDTO errorMesage = new ResponseErrorDTO(
                Integer.toString(status.value()),
                ERROR_PARAMETROS_CABECERA
        );

        return new ResponseEntity<>(errorMesage, headers, status);
    }

}
