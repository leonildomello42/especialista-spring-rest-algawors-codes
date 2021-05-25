package com.algaworks.algafoodapi.api.exceptionhandler;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.exception.NegocioException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler{

    @ExceptionHandler(EntidadeNaoEncontradaException.class)
    public ResponseEntity<?> tratarEntidadeNaoEncontradaException(
            EntidadeNaoEncontradaException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),
                HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler(EntidadeEmUsoException.class)
    public ResponseEntity<?> tratarEntidadeEmUsoException(
            EntidadeEmUsoException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),
                HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler(NegocioException.class)
    public ResponseEntity<?> tratarNegocioException(NegocioException ex, WebRequest request) {

        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(),
                HttpStatus.BAD_REQUEST, request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
                                                             HttpStatus status, WebRequest request) {

        if (body == null) {

            body = new Problema(LocalDateTime.now(), status.getReasonPhrase());
        }
        else if (body instanceof String) {

            body = new Problema(LocalDateTime.now(), (String) body);
        }
        return super.handleExceptionInternal(ex, body, headers, status, request);
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
