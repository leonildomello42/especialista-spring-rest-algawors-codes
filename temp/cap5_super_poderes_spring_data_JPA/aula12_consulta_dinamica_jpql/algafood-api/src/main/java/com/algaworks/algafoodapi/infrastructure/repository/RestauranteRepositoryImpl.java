package com.algaworks.algafoodapi.infrastructure.repository;

import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepositoryQueries;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){

        var jpql = new StringBuilder();
        jpql.append("from Restaurante where 0 = 0 ");

        var paramentros = new HashMap<String, Object>();

        if(StringUtils.hasLength(nome)){

            jpql.append("and nome like :nome ");
            paramentros.put("nome", "%" + nome + "%");
        }

        if(taxaFreteInicial != null){

            jpql.append("and taxaFrete >= :taxaFreteInicial ");
            paramentros.put("taxaFreteInicial", taxaFreteInicial);
        }

        if(taxaFreteFinal != null){

            jpql.append("and taxaFrete <= :taxaFreteFinal ");
            paramentros.put("taxaFreteFinal", taxaFreteFinal);
        }

        TypedQuery<Restaurante> query =  manager.createQuery(jpql.toString(), Restaurante.class);

        paramentros.forEach((chave, valor) -> query.setParameter(chave, valor));

        return query.getResultList();
    }
}
