package com.mercadolibre.domain.service.model;

import com.mercadolibre.adapter.externalservice.entity.Mutant;
import com.mercadolibre.domain.repository.MutantRepository;
import com.mercadolibre.domain.service.model.response.ResponseMutantDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class MutantService {

    /**
     * Letras permitidas en secuencia
     */
    @Value(value = "${allowed.cha}")
    private List<String> characters;

    @Value(value = "${matrix.size}")
    private int matrixSize;


    private static final Logger log = LoggerFactory.getLogger(MutantService.class);

    @Autowired
    MutantRepository mutantRepository;

    public  int countOblicuo=0;
    public  int contHorizontal=0;
    public  int secuenciasOblicua=0;
    public  int secuenciashorizontal=0;
    public  int countVert=0;
    public  int secuenciaVert=0;

    private void initializersContactors() {
        countOblicuo=1;
        contHorizontal=1;
        secuenciasOblicua=0;
        secuenciashorizontal=0;
        countVert=1;
        secuenciaVert=0;
    }

    /**
     * isMutant
     * @param dna
     * @return
     */
    public ResponseEntity<Object> isMutant(String [] dna) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        initializersContactors();
        boolean validate = false;

        if (validateCharacters(dna)) {
            for (int i = 0; i < dna.length; i++) {
                oblicuo(dna, i);

                if (validate)
                    break;

                for (int j = 0; j < dna.length; j++) {

                    if (secuenciashorizontal == 2 || secuenciaVert == 2
                            || (secuenciashorizontal == 1 && secuenciaVert == 1)
                            || (secuenciasOblicua==1 && (secuenciashorizontal==1 || secuenciaVert==1))) {
                        validate = true;
                        break;
                    }
                    horizontal(dna, i, j);
                    vertical(dna, i, j);
                }
            }
            String adn = Arrays.asList(dna).toString();
            saveMutante(adn, validate);
        }

        if(!validate) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(true, HttpStatus.OK);

    }

    /**
     * Stats
     * @return
     */
    public ResponseEntity<Object> stats() {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        Iterable<Mutant> mutatn= mutantRepository.findAll();
        ResponseMutantDTO r=new ResponseMutantDTO();
        Iterator<Mutant> it=mutatn.iterator();
        int contMutant=0;
        int countHuman=0;
        while (it.hasNext()) {
            Mutant mu = it.next();
            if(mu.isMutant()) {
                contMutant++;
            }

            countHuman++;

        }
        r.setCountHumanDNA(countHuman);
        r.setCountMutantDNA(contMutant);
        r.setRatio(Double.valueOf(contMutant)/Double.valueOf(countHuman));
        return new ResponseEntity<>(r, HttpStatus.OK);

    }
    /**
     * validateCharactersOk
     * @param dna
     * @return
     */
    public  boolean validateCharacters(String [] dna ) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        List<String> secondList = null;
        Integer size = 0;
        Integer newArray = (dna.length*matrixSize);
        if (dna.length == matrixSize) {

            String [] nuevo = new String[newArray];
            int index = 0;
            for(String chart : dna){
                dna = chart.split("");
                int key = 0;
                for(String post :dna){
                    nuevo[index] = dna[key];
                    index++;
                    key++;
                }
            }
            secondList = new ArrayList<>(Arrays.asList(nuevo));
            secondList.retainAll(characters);
            size = secondList.size();
        } else {
            log.info("no tiene el numero de secuencias permitidas para DNA");
        }

        return size==newArray;
    }
    /**
     * oblicuo
     * @param dna
     * @param i
     */
    public  void oblicuo(String[] dna, int i) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        Integer indexMas = i + 1;
        if (indexMas < dna.length) {
            String valActual = dna[i].split("")[i];
            String valSiguiente = dna[indexMas].split("")[indexMas];

            if (countOblicuo == 4) {
                secuenciasOblicua++;
                countOblicuo = 1;
                if(secuenciasOblicua==2) {
                    return;
                }
            }
            /**
             * OBLICUO
             */
            if (valActual.equals(valSiguiente)) {
                countOblicuo++;
            }
            else {
                countOblicuo=1;
            }
        }
    }
    /**
     * horizontal
     * @param dna
     * @param i
     * @param j
     */
    public void horizontal(String [] dna, int i,int j) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        int index = j + 1;
        if (index < dna.length) {
            String valorAc = dna[i].split("")[index];
            String valorAnt = dna[i].split("")[j];

            if (valorAc.equals(valorAnt)) {
                contHorizontal++;
                if(j==0) {
                    contHorizontal=2;
                }
                if (contHorizontal == 4) {
                    secuenciashorizontal++;
                    contHorizontal = 1;
                }
            }
            else {
                contHorizontal = 1;
            }
            if(secuenciashorizontal==2) {
                return;
            }
        }
    }
    /**
     * vertical
     * @param dna
     * @param i
     * @param j
     */
    public  void vertical(String [] dna, int i,int j) {
        log.info(Thread.currentThread().getStackTrace()[1].getMethodName());
        String valActual = dna[j].split("")[i];
        String valAnterior = "";
        if (j > 0) {
            valAnterior = dna[j - 1].split("")[i];
        }
        if (countVert == 4) {
            secuenciaVert++;
            countVert = 1;
        }

        if (valActual.equals(valAnterior)) {
            countVert++;
        } else {
            countVert = 1;
        }

    }
    /**
     * guardarMutante
     * @param adn
     * @param validate
     */
    public void saveMutante(String adn, boolean validate) {
        Mutant m=new Mutant();
        m.setFirstName(adn);
        m.setMutant(validate);
        mutantRepository.save(m);
    }


}
