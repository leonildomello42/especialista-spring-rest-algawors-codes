package com.algaworks.algafoodapi;


import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.service.CadastroCozinhaService;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CadastroCozinhaIntegrationTests {

	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos()  {

		// cenário
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Teste");

		// ação
		novaCozinha = cadastroCozinha.salvar(novaCozinha);

		// validação
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}

	@Test(expected = ConstraintViolationException.class)
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {

		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		novaCozinha = cadastroCozinha.salvar(novaCozinha);
	}

//	@Test - junit5
//	public void testarCadastroCozinhaSemNome() {
//		Cozinha novaCozinha = new Cozinha();
//		novaCozinha.setNome(null);
//
//		ConstraintViolationException erroEsperado =
//				Assertions.assertThrows(ConstraintViolationException.class, () -> {
//					cadastroCozinha.salvar(novaCozinha);
//				});
//
//		assertThat(erroEsperado).isNotNull();
//	}
}
