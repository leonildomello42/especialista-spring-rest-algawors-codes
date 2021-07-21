package com.algaworks.algafoodapi.jpa.testes;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.jpa.CadastroCozinha;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;

public class ConsultaCozinhaMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        CadastroCozinha cadastroCozinha =  applicationContext.getBean(CadastroCozinha.class);
        List<Cozinha> cozinhas =  cadastroCozinha.listar();

        for (Cozinha cozinha : cozinhas){
            System.out.println(cozinha.getNome());
        }

        System.out.println("----------------------");

        Iterator<Cozinha> iterator = cozinhas.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().getNome());
        }
    }
}
