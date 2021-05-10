package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AtivacaoClienteService {

    // 3 - ponto de injecao: No atributo
    @Autowired
    private Notificador notificador;

    /* 1 - Ponto de injecao: No construtor - IDEAL
    //Torna esse o construtor padrao
    @Autowired
    public AtivacaoClienteService(NotificadorEmail notificador){
        this.notificador = notificador;
    } */

    public void ativer(Cliente cliente){

        cliente.ativar();
        this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }

    /* 2 Ponto de injecao: No método setter
    @Autowired
    public void setNotificador(Notificador notificador) {
        this.notificador = notificador;
    } */
}
