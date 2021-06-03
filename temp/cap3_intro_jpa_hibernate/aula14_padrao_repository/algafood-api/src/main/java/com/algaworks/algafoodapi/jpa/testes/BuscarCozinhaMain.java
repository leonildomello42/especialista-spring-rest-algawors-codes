package com.algaworks.algafoodapi.jpa.testes;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscarCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CozinhaRepository cadastroCozinha =  applicationContext.getBean(CozinhaRepository.class);

        Cozinha cozinha1 = cadastroCozinha.buscar(1L);

        System.out.println("Cozinha pesquisada:  " + cozinha1.getId() + " " + cozinha1.getNome());
    }
}
