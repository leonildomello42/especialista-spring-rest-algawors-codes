package com.algaworks.algafoodapi;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CadastroCozinhaAPIIT {

	@LocalServerPort
	private int port;

	@Test
	public void deveRetornarStatus200_QuandoConsultarCozinhas() {

		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

		given()
				.basePath("/cozinhas")
				.port(port)
				.accept(ContentType.JSON)
		.when()
				.get()
		.then()
				.statusCode(HttpStatus.OK.value());
	}

//	@Test
//	public void deveRetornarStatus200_OLD_QuandoConsultarCozinhas() {
//
//		RestAssured
//				.given()
//				.basePath("/cozinhas")
//				.port(port)
//				.accept(ContentType.JSON)
//
//				.when()
//				.get()
//
//				.then()
//				.statusCode(HttpStatus.NOT_FOUND.value());
//	}
}
