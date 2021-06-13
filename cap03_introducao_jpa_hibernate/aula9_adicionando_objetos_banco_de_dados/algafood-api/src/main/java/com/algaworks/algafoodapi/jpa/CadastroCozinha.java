package com.algaworks.algafoodapi.jpa;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Cozinha adicionar(Cozinha cozinha){
        Cozinha cozinha1 = entityManager.merge(cozinha);
        return cozinha1;
    }

    public Cozinha buscarId(Long id){
        return entityManager.find(Cozinha.class, id);
    }
}
