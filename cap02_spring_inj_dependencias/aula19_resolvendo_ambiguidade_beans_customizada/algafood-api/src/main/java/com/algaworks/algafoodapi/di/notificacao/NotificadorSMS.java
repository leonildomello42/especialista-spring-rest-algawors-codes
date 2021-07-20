package com.algaworks.algafoodapi.di.notificacao;

import com.algaworks.algafoodapi.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@TipoDoNotificador(value = NivelUrgencia.NORMAL)
@Component
public class NotificadorSMS implements Notificador {

	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.printf("Notificando %s por SMS atraveés do telefone %s: %s\n",
				cliente.getNome(), cliente.getTelefone(), mensagem);
	}
}
