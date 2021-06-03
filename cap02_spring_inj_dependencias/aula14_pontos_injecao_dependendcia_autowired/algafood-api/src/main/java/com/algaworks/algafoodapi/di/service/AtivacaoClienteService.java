package com.algaworks.algafoodapi.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;
import com.algaworks.algafoodapi.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	
	//Ponto de injecao 1
	@Autowired
	private Notificador notificador;
	
	
	//Ponto de injecao 2
//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		super();
//		this.notificador = notificador;
//	}
	

	public void ativar(Cliente cliente) {
		cliente.ativar();
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
	}

	//Ponto de injecao 3
//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
}
