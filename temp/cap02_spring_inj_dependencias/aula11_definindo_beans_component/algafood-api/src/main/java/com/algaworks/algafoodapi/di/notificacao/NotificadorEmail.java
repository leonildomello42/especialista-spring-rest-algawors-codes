package com.algaworks.algafoodapi.di.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;

@Component
public class NotificadorEmail {
	
	public NotificadorEmail() {
		
		System.out.println("Construtor chamado!");
	}
	
	public void notificar(Cliente cliente, String mensagem) {
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), mensagem);
	}

}
