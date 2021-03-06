package com.algaworks.algafoodapi.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EstadoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public EstadoNaoEncontradoException(String msg){
        super(msg);
    }

    public EstadoNaoEncontradoException(Long estadoId){
        this(String.format("Não existe um cadastro de estado com o código %d" ,estadoId));
    }
}
