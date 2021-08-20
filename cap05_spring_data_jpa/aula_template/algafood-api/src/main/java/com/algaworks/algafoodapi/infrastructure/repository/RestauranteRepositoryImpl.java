package com.algaworks.algafoodapi.infrastructure.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepositoryQueries;
import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;


    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){

        String jpql = "FROM Restaurante WHERE nome LIKE :nome " +
                "AND taxaFrete BETWEEN :taxaInicial AND :taxaFinal";

        TypedQuery<Restaurante> query =  manager.createQuery(jpql, Restaurante.class)
                .setParameter("nome", "%"+ nome + "%")
                .setParameter("taxaInicial", taxaFreteInicial)
                .setParameter("taxaFinal", taxaFreteFinal);

        return query.getResultList();
    }


    //Código aula
//    @Override
//    public List<Restaurante> find(String nome,
//                                  BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
//
//        var jpql = "from Restaurante where nome like :nome "
//                + "and taxaFrete between :taxaInicial and :taxaFinal";
//
//        return manager.createQuery(jpql, Restaurante.class)
//                .setParameter("nome", "%" + nome + "%")
//                .setParameter("taxaInicial", taxaFreteInicial)
//                .setParameter("taxaFinal", taxaFreteFinal)
//                .getResultList();
//    }
}
