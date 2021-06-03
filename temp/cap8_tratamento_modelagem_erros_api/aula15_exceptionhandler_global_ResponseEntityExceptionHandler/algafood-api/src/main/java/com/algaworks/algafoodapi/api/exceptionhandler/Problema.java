package com.algaworks.algafoodapi.api.exceptionhandler;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.stream.IntStream;

public class Problema implements Serializable{

    private static final long serialVersionUID = 1L;

    private LocalDateTime dataHora;
    private String mensagem;

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Problema(){

    }

    public Problema(LocalDateTime dataHora, String mensagem) {
        this.dataHora = dataHora;
        this.mensagem = mensagem;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
