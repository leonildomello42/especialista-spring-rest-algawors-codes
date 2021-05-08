package com.algaworks.algafood.di.notificacao;

import com.algaworks.algafood.di.modelo.Cliente;


public class NotificadorEmail implements Notificador {

    private boolean caixaAlta = false;
    private String hostServidorSmtp;

    public  NotificadorEmail(String hostServidorSmtp){
        this.hostServidorSmtp = hostServidorSmtp;
        System.out.println("Constrututor chamado");
    }

    @Override
    public void notificar(Cliente cliente, String mensagem){

        if(this.caixaAlta){
            mensagem = mensagem.toUpperCase();
        }

        System.out.printf("Notificando %s através do e-mail %s, usando SMTP %s: %s\n",
                cliente.getNome(), cliente.getEmail(), this.hostServidorSmtp ,mensagem);
    }

    public void setCaixaAlta(boolean caixaAlta){
        this.caixaAlta = caixaAlta;
    }
}
