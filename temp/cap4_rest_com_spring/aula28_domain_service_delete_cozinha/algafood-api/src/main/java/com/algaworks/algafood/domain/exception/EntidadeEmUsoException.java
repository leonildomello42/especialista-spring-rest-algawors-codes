package com.algaworks.algafood.domain.exception;

import java.io.Serializable;

public class EntidadeEmUsoException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public EntidadeEmUsoException(String msg){
        super(msg);
    }
}
