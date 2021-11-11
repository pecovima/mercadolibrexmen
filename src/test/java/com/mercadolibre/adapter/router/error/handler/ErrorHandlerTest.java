package com.mercadolibre.adapter.router.error.handler;

import com.mercadolibre.adapter.router.controller.MutantRestController;
import com.mercadolibre.domain.service.model.request.MutantDTO;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.context.request.WebRequest;

import static org.junit.Assert.assertNotNull;

public class ErrorHandlerTest {
    private ErrorHandler errorHandler;
    private MutantRestController mutantRestController;
    private DataBinder dataBinder;
    private WebRequest request;

    @Before
    public void init(){
        errorHandler = new ErrorHandler();
        mutantRestController = new MutantRestController();
        dataBinder = new DataBinder(mutantRestController);
        request = Mockito.mock(WebRequest.class);
    }

  /*  @Test
    public void () throws NoSuchMethodException{
        MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(
                new MethodParameter(MutantRestController.class.getMethod("isMutant", MutantDTO.class),-1),
                dataBinder.getBindingResult());
        assertNotNull(errorHandler.handleMethodArgumentNotValid(methodArgumentNotValidException,new HttpHeaders(), HttpStatus.BAD_GATEWAY,request));
    }*/


}

