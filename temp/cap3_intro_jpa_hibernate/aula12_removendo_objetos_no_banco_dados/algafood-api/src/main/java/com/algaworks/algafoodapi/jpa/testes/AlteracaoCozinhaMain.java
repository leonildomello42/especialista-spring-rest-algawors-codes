package com.algaworks.algafoodapi.jpa.testes;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.jpa.CadastroCozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class AlteracaoCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CadastroCozinha cadastroCozinha =  applicationContext.getBean(CadastroCozinha.class);

        Cozinha cozinha = new Cozinha();
        cozinha.setId(1L);
        cozinha.setNome("Brasileira");

        cozinha = cadastroCozinha.salvar(cozinha);
        System.out.println("Id da cozinha modificada: " + cozinha.getId() + " " + cozinha.getNome());


        String nome = "Cozinha alterada";
        Cozinha cozinha2 = cadastroCozinha.atualizar(nome, 2L);
        System.out.println("Id da cozinha modificada: " + cozinha2.getId() + " " + cozinha2.getNome());
    }
}
