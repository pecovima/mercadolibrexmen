package com.mercadolibre.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MutantExceptionTest {
    private String code;
    private String message;

    @BeforeEach
    void init(){
        code = "404";
        message = "error no identificado";
    }

    @Test
    void constructorConArgumentos(){
        MutantException excepion = new MutantException(code,message);
        assertNotNull(excepion);
        assertEquals(code, excepion.getCode());
        assertEquals(message, excepion.getMessage());
    }

    @Test
    void constructorSinArgumentos(){
        MutantException excepion = new MutantException();
        excepion.setCode(code);
        excepion.setMessage(message);
        assertNotNull(excepion);
        assertEquals(code, excepion.getCode());
        assertEquals(message, excepion.getMessage());
    }
}
