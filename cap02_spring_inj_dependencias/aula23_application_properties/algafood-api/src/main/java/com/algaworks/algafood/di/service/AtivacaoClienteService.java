package com.algaworks.algafood.di.service;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AtivacaoClienteService {


    @Autowired
    private ApplicationEventPublisher eventPublisher;

    public void ativer(Cliente cliente){

        cliente.ativar();

        //dizer para o conteiner que o cliente está ativo
        eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
    }
}
