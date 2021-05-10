package com.algaworks.algafoodapi.di.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;
import com.algaworks.algafoodapi.di.notificacao.NivelUrgencia;
import com.algaworks.algafoodapi.di.notificacao.Notificador;
import com.algaworks.algafoodapi.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {
	
	@Autowired
	private ApplicationEventPublisher eventPublisher;
	
	
	public void ativar(Cliente cliente) {
		
		cliente.ativar();
		
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
			
	}
}
