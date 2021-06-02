package com.algaworks.algafoodapi;


import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.util.DatabaseCleaner;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.flywaydb.core.Flyway;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.regex.Matcher;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource("/application-test.properties")
public class CadastroCozinhaAPIIT {

	@LocalServerPort
	private int port;

	@Autowired
	DatabaseCleaner databaseCleaner;

	@Autowired
	CozinhaRepository cozinhaRepository;

	@Before
	public void setUp() {
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		RestAssured.port = port;
		RestAssured.basePath = "/cozinhas";

		databaseCleaner.clearTables();
		prepararDados();
	}

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {
		given()
				.accept(ContentType.JSON)
				.when()
				.get()
				.then()
				.statusCode(HttpStatus.OK.value());
	}

	@Test
	public void deveConter4Cozinhas_QuandoConsultarCozinhas() {
		given()
				.accept(ContentType.JSON)
				.when()
				.get()
				.then()
				.body("", Matchers.hasSize(2));
	}

	@Test
	public void deveRetornarStatus201_QuandoCadastrarCozinha() {
		given()
				.body("{ \"nome\": \"Chinesa\" }")
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.when()
				.post()
				.then()
				.statusCode(HttpStatus.CREATED.value());
	}

	@Test
	public void deveRetornarRespostaStatusCorretos_QuandoConsultarCozinhaExistente(){

		given()
				.pathParam("cozinhaId", 2L)
				.accept(ContentType.JSON)
				.when()
				.get("/{cozinhaId}")
				.then()
				.statusCode(HttpStatus.OK.value())
				.body("nome", equalTo("Americana"));

	}

	@Test
	public void deveRetornarStatus404_QuandoConsultarCozinhaInexistente(){

		given()
				.pathParam("cozinhaId", 200L)
				.accept(ContentType.JSON)
				.when()
				.get("/{cozinhaId}")
				.then()
				.statusCode(HttpStatus.NOT_FOUND.value());

	}

	private void prepararDados(){

		Cozinha cozinha1 = new Cozinha();
		cozinha1.setNome("Tailandesa");
		cozinhaRepository.save(cozinha1);

		Cozinha cozinha2 = new Cozinha();
		cozinha2.setNome("Americana");
		cozinhaRepository.save(cozinha2);
	}

}
