package com.algaworks.algafoodapi.di.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;
import com.algaworks.algafoodapi.di.notificacao.NivelUrgencia;
import com.algaworks.algafoodapi.di.notificacao.Notificador;
import com.algaworks.algafoodapi.di.notificacao.TipoDoNotificador;

//@Component
public class AtivacaoClienteService {
	
	
	@Autowired(required = false)
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	private Notificador notificador;
	
	
	//@PostConstruct
	public void init() {
		
		System.out.println("INIT");
	}
	
	//@PreDestroy
	public void destroy() {
		
		System.out.println("DESTROY");
	}
	
	public void ativar(Cliente cliente) {
		
		cliente.ativar();
			
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");	
	}
}
