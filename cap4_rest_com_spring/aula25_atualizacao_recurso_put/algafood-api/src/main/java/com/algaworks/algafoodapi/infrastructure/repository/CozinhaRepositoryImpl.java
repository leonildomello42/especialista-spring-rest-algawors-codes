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
    public EntityManager manager;

    @Override
    public List<Cozinha> listar(){

        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
        List<Cozinha> cozinhas = query.getResultList();

        return cozinhas;
    }

    @Override
    public Cozinha buscar(Long id){
        return manager.find(Cozinha.class, id);
    }

    @Override
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

    @Override
    @Transactional
    public void remover(Cozinha cozinha){
        cozinha = buscar(cozinha.getId());
        manager.remove(cozinha);
    }


}
