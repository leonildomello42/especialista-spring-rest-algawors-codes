package com.algaworks.algafoodapi.infrastructure.repository;

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
public class CozinhaRepositoryImpl {

    @PersistenceContext
    private EntityManager manager;

//    @Override
    public List<Cozinha> listar(){

        TypedQuery<Cozinha> query = manager.createQuery("FROM Cozinha ", Cozinha.class);
        return query.getResultList();
    }

//    @Override
//    public List<Cozinha> consultarPorNome(String nome) {
//
//        TypedQuery<Cozinha> query = manager.createQuery("FROM Cozinha WHERE nome = :nome", Cozinha.class)
//                .setParameter("nome", nome);
//
//        return query.getResultList();
//    }

//    @Override
    public List<Cozinha> consultarPorNome(String nome) {

        TypedQuery<Cozinha> query = manager.createQuery("FROM Cozinha WHERE nome LIKE :nome", Cozinha.class)
                .setParameter("nome", "%" + nome + "%");

        return query.getResultList();
    }

//    @Override
    public Cozinha buscar(Long id){

        return manager.find(Cozinha.class, id);
    }

    @Transactional
//    @Override
    public Cozinha salvar(Cozinha cozinha){
        return manager.merge(cozinha);
    }

    @Transactional
//    @Override
    public void remover(Long id){
        Cozinha cozinha = buscar(id);

        if(cozinha == null){
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }

}
