package com.algaworks.algafoodapi.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafoodapi.di.modelo.Cliente;

@TipoDoNotificador(value = NivelUrgencia.URGENTE)
@Component
public class NotificadorEmail implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.printf("Notificando %s através do e-mail %s: %s\n",
				cliente.getNome(), cliente.getEmail(), mensagem);
	}
}
