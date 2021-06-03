package com.algaworks.algafoodapi.api.exceptionhandler;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.exception.NegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> tratarEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e){

        Problema problema = new Problema(LocalDateTime.now(), e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> tratarNegocioException(NegocioException e){

        Problema problema = new Problema(LocalDateTime.now(), e.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
    }


    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> tratarEntidadeEmUsoException(EntidadeEmUsoException e) {

        Problema problema = new Problema(LocalDateTime.now(), e.getMessage());

        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(problema);
    }

    // o extends ja trata as excecoes internas
//    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
//    public ResponseEntity<?> tratarHttpMediaTypeNotSupportedException() {
//
//        Problema problema = new Problema(LocalDateTime.now(), "O tipo de mídia não é aceito");
//
//        return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
//                .body(problema);
//    }
}
