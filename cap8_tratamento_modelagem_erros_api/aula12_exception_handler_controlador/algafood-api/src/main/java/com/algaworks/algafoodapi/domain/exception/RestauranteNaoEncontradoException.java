package com.algaworks.algafoodapi.domain.exception;

public class RestauranteNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public RestauranteNaoEncontradoException(String msg){
        super(msg);
    }

    public RestauranteNaoEncontradoException(Long restauranteId){
        this(String.format("Não existe um cadastro de estado com o código %d" ,restauranteId));
    }
}
