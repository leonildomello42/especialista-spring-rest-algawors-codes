package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.FormaPagamento;
import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class FormaPagamentoImpl implements FormaPagamentoRepository {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<FormaPagamento> listar(){

        TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagemto", FormaPagamento.class);
        return query.getResultList();
    }

    @Override
    public FormaPagamento buscar(Long id){

        return manager.find(FormaPagamento.class,id);
    }

    @Transactional
    @Override
    public FormaPagamento salvar(FormaPagamento formaPagamento){

        return manager.merge(formaPagamento);
    }

    public void remover(FormaPagamento formaPagamento){

        formaPagamento = buscar(formaPagamento.getId());
        manager.remove(formaPagamento);
    }
}
