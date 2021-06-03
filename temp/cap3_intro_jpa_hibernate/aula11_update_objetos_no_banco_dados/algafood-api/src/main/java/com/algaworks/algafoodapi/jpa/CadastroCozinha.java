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
    public EntityManager manager;

    public List<Cozinha> listar(){

        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
        List<Cozinha> cozinhas = query.getResultList();

        return cozinhas;
    }

    public Cozinha buscar(Long id){
        return manager.find(Cozinha.class, id);
    }

    @Transactional
    public Cozinha salvar(Cozinha cozinha){

        Cozinha cozinhaSalva = manager.merge(cozinha);
        return cozinhaSalva;
    }

    @Transactional
    public Cozinha atualizar(String nome, Long id){

        Cozinha cozinha1 = buscar(id);
        cozinha1.setNome(nome);

        return manager.merge(cozinha1);
    }
}
