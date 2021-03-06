package com.algaworks.algafood.jpa;

import com.algaworks.algafood.AlgafoodApiApplication;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

public class BuscaFormaPagamentoMain {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApiApplication.class)
           .web(WebApplicationType.NONE)
           .run(args);

        FormaPagamentoRepository formaPagamento = applicationContext.getBean(FormaPagamentoRepository.class);
        FormaPagamento formaPagamento1 =  formaPagamento.buscar(1L);

        System.out.println(formaPagamento1.getDescricao());

    }
}
