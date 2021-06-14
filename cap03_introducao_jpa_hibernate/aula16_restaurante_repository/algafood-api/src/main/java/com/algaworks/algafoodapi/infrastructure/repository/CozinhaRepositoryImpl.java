package com.algaworks.algafoodapi.infrastructure.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CozinhaRepositoryImpl implements CozinhaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Cozinha> listar(){
        TypedQuery<Cozinha> query = entityManager.createQuery("FROM Cozinha", Cozinha.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public Cozinha salvar(Cozinha cozinha){
        Cozinha cozinha1 = entityManager.merge(cozinha);
        return cozinha1;
    }

    @Override
    public Cozinha buscarId(Long id){
        return entityManager.find(Cozinha.class, id);
    }

    @Override
    @Transactional
    public void remover(Cozinha cozinha){

        cozinha = buscarId(cozinha.getId());
        entityManager.remove(cozinha);
    }
}
