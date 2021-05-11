package com.algaworks.algafoodapi.jpa;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext
    public EntityManager manager;

    public List<Cozinha> listar(){

        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
        List<Cozinha> cozinhas = query.getResultList();

        return cozinhas;
    }
}
