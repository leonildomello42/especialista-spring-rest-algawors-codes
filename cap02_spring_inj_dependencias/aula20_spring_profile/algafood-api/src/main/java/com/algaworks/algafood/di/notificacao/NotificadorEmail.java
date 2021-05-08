package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("prod")
@TipoDoNotificador(value = NivelUrgencia.NORMAL)
@Component
public class NotificadorEmail implements Notificador{

    public NotificadorEmail(){

        System.out.println("Notificador real");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){

        System.out.printf("Notificando %s através do e-mail %s: %s\n",
                cliente.getNome(), cliente.getEmail(), mensagem);
    }
}
