package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class AtivacaoClienteService {

    private NotificadorEmail notificador;

    public void ativer(Cliente cliente){

        cliente.ativar();

        this.notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
    }
}
