package com.mercadolibre.adapter.router.facade;

import com.mercadolibre.AppUnifiedXmenMagneto;
import com.mercadolibre.domain.service.model.MutantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppUnifiedXmenMagneto.class)
public class MutantFacadeTest {

    @Autowired
    private MutantFacade mutantFacade;

    @MockBean
    private MutantService mutantService;

    @Test
    public void postIsMutant(){
        when(mutantService.isMutant(any())).thenReturn(new ResponseEntity<>("", HttpStatus.OK));
        assertNotNull(mutantService.isMutant(new String[0]));
    }

    @Test
    public void getStats(){
        when(mutantFacade.stats()).thenReturn(new ResponseEntity<>("", HttpStatus.OK));
        assertNotNull(mutantFacade.stats());
    }
}
