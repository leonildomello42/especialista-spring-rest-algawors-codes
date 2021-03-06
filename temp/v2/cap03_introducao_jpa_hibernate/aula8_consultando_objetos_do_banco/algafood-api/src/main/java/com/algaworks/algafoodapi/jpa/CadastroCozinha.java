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
    private EntityManager entityManager;

    public List<Cozinha> listar(){
        TypedQuery<Cozinha> query = entityManager.createQuery("FROM Cozinha", Cozinha.class);
        return query.getResultList();
    }
}
