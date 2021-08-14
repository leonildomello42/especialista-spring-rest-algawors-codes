package com.algaworks.algafoodapi.jpa.testes;

import com.algaworks.algafoodapi.AlgafoodApiApplication;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;

public class ConsultaRestauranteMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);

        RestauranteRepository restaurantes =  applicationContext.getBean(RestauranteRepository.class);
        List<Restaurante> listRestaurantes =  restaurantes.listar();

        for (Restaurante res : listRestaurantes){
            System.out.println(res.getNome() + " ---- "+ res.getCozinha().getNome());
        }

        System.out.println("----------------------");

        Iterator<Restaurante> iterator = listRestaurantes.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next().getCozinha().getNome());
        }
    }
}