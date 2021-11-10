package com.mercadolibre.domain.service.model.response;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ResponseMutantDTOTest {

    private Integer countHumanDNA;
    private Integer countMutantDNA;
    private Double ratio;

    @Before
    public void init(){
        countHumanDNA = 20;
        countMutantDNA= 20;
        ratio =1.0;

    }

    @Test
    public void contructorConArgumentos(){
        ResponseMutantDTO response = new ResponseMutantDTO(countHumanDNA,countMutantDNA,ratio);

        assertNotNull(response);
        assertEquals(countHumanDNA, response.getCountHumanDNA());
        assertEquals(countMutantDNA, response.getCountMutantDNA());
        assertEquals(ratio, response.getRatio());
    }

    @Test
    public void contructorSinArgumentos(){
        ResponseMutantDTO response = new ResponseMutantDTO();
        response.setCountHumanDNA(countHumanDNA);
        response.setCountMutantDNA(countMutantDNA);
        response.setRatio(ratio);
        assertNotNull(response);
        assertEquals(countHumanDNA, response.getCountHumanDNA());
        assertEquals(countMutantDNA, response.getCountMutantDNA());
        assertEquals(ratio, response.getRatio());
    }
}
