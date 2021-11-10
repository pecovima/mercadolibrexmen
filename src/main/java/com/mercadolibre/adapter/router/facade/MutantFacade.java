package com.mercadolibre.adapter.router.facade;


import com.mercadolibre.domain.service.model.MutantService;
import com.mercadolibre.domain.service.model.request.MutantDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class MutantFacade {

    @Autowired
    MutantService mutantService;

    public ResponseEntity<Object> isMutant(MutantDTO requestMs){
        return mutantService.isMutant(requestMs.getDna());
    }

    public ResponseEntity<Object> stats(){
        return mutantService.stats();
    }


}
