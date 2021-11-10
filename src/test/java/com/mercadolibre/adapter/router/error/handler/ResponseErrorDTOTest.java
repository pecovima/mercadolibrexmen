package com.mercadolibre.adapter.router.error.handler;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResponseErrorDTOTest {

    private String code;
    private String message;

    @Before
    public void init(){
        code = "404";
        message = "error";
    }

    @Test
    public void contructorConArgumentos(){
        ResponseErrorDTO error = new ResponseErrorDTO(code,message);

        assertNotNull(error);
        assertEquals(code, error.getCode());
        assertEquals(message, error.getMessage());
    }

    @Test
    public void contructorSinArgumentos(){
        ResponseErrorDTO error = new ResponseErrorDTO();
        error.setCode(code);
        error.setMessage(message);
        assertNotNull(error);
        assertEquals(code, error.getCode());
        assertEquals(message, error.getMessage());
    }
}
