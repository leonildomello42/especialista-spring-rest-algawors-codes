package com.algaworks.algafood.jpa;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class CadastroCozinha {


    @PersistenceContext
    private EntityManager manager;

    public List<Cozinha> findAll(){
        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    public Cozinha findById(Long id){
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    public Cozinha salvar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    @Transactional
    public void delete (Cozinha cozinha){

        cozinha = findById(cozinha.getId());
        manager.remove(cozinha);
    }

}
