package com.algaworks.algafoodapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.algaworks.algafoodapi.di.notificacao.NotificadorEmail;

@Configuration
public class NotificacaoConfig {
	
	
	
	@Bean
	public NotificadorEmail notificadorEmail() {
		
		NotificadorEmail notificadorEmail = new NotificadorEmail("smtp.algamail.com");
		notificadorEmail.setCaixaAlta(true);
		
		return notificadorEmail;
	}

}
