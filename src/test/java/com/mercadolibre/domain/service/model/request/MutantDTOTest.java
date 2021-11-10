package com.mercadolibre.domain.service.model.request;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MutantDTOTest {

   private String [] dna;

    @Before
    public void init(){
        dna = new String[]{"ACAAAA",
                        "BATAAA",
                        "LBQBBY",
                        "MBBAAA",
                        "NBCBAA",
                        "CCCCGB"};
    }

    @Test
    public void contructorConArgumentos(){
        MutantDTO request = new MutantDTO(dna);

        assertNotNull(request);
        //assertEquals(dna, request.getDna());
    }

    @Test
    public void contructorSinArgumentos(){
        MutantDTO request = new MutantDTO(dna);
        request.setDna(dna);
        assertNotNull(request);
    }
}
