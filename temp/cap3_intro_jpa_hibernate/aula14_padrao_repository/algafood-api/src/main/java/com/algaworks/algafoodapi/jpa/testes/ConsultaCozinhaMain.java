package com.algaworks.algafoodapi.jpa.testes;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.repository.CozinhaRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);


        CozinhaRepository cadastroCozinha =  applicationContext.getBean(CozinhaRepository.class);
        List<Cozinha> cozinhas =  cadastroCozinha.listar();

        for(Cozinha cozinha : cozinhas){
            System.out.println("Cozinha: " + cozinha.getNome());
        }
    }
}
