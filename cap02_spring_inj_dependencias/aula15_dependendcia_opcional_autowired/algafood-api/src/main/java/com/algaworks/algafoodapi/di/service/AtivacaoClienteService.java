package com.algaworks.algafoodapi.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;
import com.algaworks.algafoodapi.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {
	
	
	@Autowired(required = false)
	private Notificador notificador;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		if(notificador != null) {
			
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}
		else {
			
			System.out.println("Não existe instacia de notificador");
		}

	}

	
}
