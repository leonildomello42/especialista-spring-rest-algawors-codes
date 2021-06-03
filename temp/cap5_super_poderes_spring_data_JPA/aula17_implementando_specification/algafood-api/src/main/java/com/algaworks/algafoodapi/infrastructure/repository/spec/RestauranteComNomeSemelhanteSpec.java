package com.algaworks.algafoodapi.infrastructure.repository.spec;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;

public class RestauranteComNomeSemelhanteSpec implements Specification<Restaurante> {


    private static final long serialVersionUID = 1L;

    private String nome;

    public RestauranteComNomeSemelhanteSpec(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public Predicate toPredicate(Root<Restaurante> root, CriteriaQuery<?> query,
                                 CriteriaBuilder builder) {

        return builder.like(root.get("nome"), "%"+ nome + "%");
    }

}
