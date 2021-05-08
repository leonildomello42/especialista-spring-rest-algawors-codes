package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.NotificadorEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class AtivacaoClienteService {

    @Autowired(required = false)
    private List<Notificador> notificadores;

    public void ativer(Cliente cliente){

        cliente.ativar();

        for(Notificador notificador: notificadores){

            notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
        }

    }
}
