package com.mercadolibre.domain.service;

import com.mercadolibre.adapter.externalservice.exception.ExternalServiceException;
import com.mercadolibre.AppUnifiedXmenMagneto;
import com.mercadolibre.domain.repository.MutantRepository;
import com.mercadolibre.domain.service.model.MutantService;
import com.mercadolibre.domain.service.model.request.MutantDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppUnifiedXmenMagneto.class)
public class MutantServiceTest {

    @Autowired
    private MutantService mutantService;

    @MockBean
    private MutantRepository mutantRepositositoy;

    private MutantDTO requestMs;

    @Value(value = "${allowed.cha}")
    private List<String> characters;

    @Value(value = "${matrix.size}")
    private int matrixSize;

    @Before
    public void init(){

        String[] rq =
                {"ACAAAA",
                        "TAAAAG",
                        "GTAAAA",
                        "CCCCCC",
                        "GGGAAA",
                        "CCCCGA"};
        requestMs =new MutantDTO();
        requestMs.setDna(rq);
    }

    @Test
    public void isMutantTest() throws ExternalServiceException {
        assertNotNull(mutantService.isMutant(requestMs.getDna()));
    }


}
