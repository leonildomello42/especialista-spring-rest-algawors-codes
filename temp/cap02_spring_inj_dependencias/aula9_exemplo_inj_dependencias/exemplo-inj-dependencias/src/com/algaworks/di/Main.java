package com.algaworks.di;

import com.algaworks.di.modelo.Cliente;
import com.algaworks.di.modelo.Produto;
import com.algaworks.di.notificacao.NotificadorEmail;
import com.algaworks.di.notificacao.NotificadorSMS;
import com.algaworks.di.service.AtivacaoClienteService;
import com.algaworks.di.service.EmissaoNotaFiscalService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

        Cliente joao = new Cliente("Joao", "joao@xyz.com", "3499998888");
        Cliente maria = new Cliente("Maria", "Maria@xyz.com", "1177772222");

        Produto carro = new Produto("carro", new BigDecimal("2.2"));

        AtivacaoClienteService ativacaoCliente = new AtivacaoClienteService(new NotificadorSMS());
        ativacaoCliente.ativar(joao);
        ativacaoCliente.ativar(maria);

        EmissaoNotaFiscalService emissaoNota = new EmissaoNotaFiscalService(new NotificadorSMS());
        emissaoNota.emitir(joao, carro);
    }
}
