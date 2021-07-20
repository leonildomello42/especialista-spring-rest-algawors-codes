package com.algaworks.algafoodapi.di.service;

import com.algaworks.algafoodapi.di.modelo.Cliente;
import com.algaworks.algafoodapi.di.notificacao.Notificador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AtivacaoClienteService {

	@Qualifier("email")
	@Autowired(required = false)
	private Notificador notificador;


	public void ativar(Cliente cliente) {

		cliente.ativar();
		notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");

	}
}