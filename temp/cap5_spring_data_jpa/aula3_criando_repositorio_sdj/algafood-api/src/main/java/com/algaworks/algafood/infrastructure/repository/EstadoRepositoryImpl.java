package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Estado;
import com.algaworks.algafood.domain.repository.EstadoRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EstadoRepositoryImpl implements EstadoRepository {

    @PersistenceContext
    EntityManager manager;

    @Override
    public List<Estado> listar() {

        TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
        return query.getResultList();
    }

    @Override
    public Estado buscar(Long id) {

        return manager.find(Estado.class, id);
    }

    @Override
    public Estado salvar(Estado estado) {

        return manager.merge(estado);
    }

    @Override
    public void remover(Long id) {

        Estado estado = buscar(id);
        manager.remove(estado);
    }
}
