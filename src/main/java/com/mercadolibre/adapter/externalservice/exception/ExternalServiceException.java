package com.mercadolibre.adapter.externalservice.exception;


import com.mercadolibre.domain.MutantException;

public class ExternalServiceException extends MutantException {
    public ExternalServiceException(String code, String message){super(code,message);}
}
