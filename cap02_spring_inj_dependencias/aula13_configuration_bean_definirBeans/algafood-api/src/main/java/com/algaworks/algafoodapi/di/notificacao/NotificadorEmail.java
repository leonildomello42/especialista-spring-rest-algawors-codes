package com.algaworks.algafoodapi.di.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;

//@Component
public class NotificadorEmail implements Notificador {
	
	public boolean caixaAlta;
	public String hostServidorSmtp;

	public NotificadorEmail(String hostServidorSmtp) {

		this.hostServidorSmtp = hostServidorSmtp;
		System.out.println("NotificadorEmail!");
	}

	public void setCaixaAlta(boolean caixaAlta) {
		this.caixaAlta = caixaAlta;
	}
	
	@Override
	public void notificar(Cliente cliente, String mensagem) {
		
		if(this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		
		System.out.printf("Notificando %s através do e-mail %s usando SMTP %s: %s\n", 
				cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp, mensagem);
	}
}
