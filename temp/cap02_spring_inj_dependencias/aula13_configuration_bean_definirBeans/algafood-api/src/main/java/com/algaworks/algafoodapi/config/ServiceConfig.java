package com.algaworks.algafoodapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafoodapi.di.notificacao.NotificadorEmail;
import com.algaworks.algafoodapi.di.service.AtivacaoClienteService;

@Configuration
public class ServiceConfig {
	
	
	@Bean
	public AtivacaoClienteService ativacaoClienteService(NotificadorEmail notificadorEmail) {
		
		AtivacaoClienteService ativacaoClienteService = new AtivacaoClienteService(notificadorEmail);

		return ativacaoClienteService;
	}

}
