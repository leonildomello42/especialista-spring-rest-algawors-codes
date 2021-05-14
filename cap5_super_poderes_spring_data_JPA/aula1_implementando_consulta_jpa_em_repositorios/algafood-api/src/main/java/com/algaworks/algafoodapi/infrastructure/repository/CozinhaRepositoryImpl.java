package com.algaworks.algafoodapi.infrastructure.repository;

import com.algaworks.algafoodapi.domain.model.Cidade;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
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
    public List<Cozinha> consultarPorNome(String nome) {

        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha where nome = :nome", Cozinha.class)
                .setParameter("nome", nome);

        TypedQuery<Cozinha> queryLike = manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
                .setParameter("nome", "%" + nome + "%");


        return queryLike.getResultList();
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
    public void remover(Long id){
        Cozinha cozinha = buscar(id);

        if(cozinha == null){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }
}
