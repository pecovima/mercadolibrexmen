package com.mercadolibre.adapter.router;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RouterConstsTest {
    @Test
    void validValues(){
        assertEquals("com.mercadolibre",RouterConsts.COMPONENT_SCAN);
    }

}
