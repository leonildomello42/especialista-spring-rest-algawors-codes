package com.algaworks.algafood.infrastructure.repository;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;
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
    EntityManager maneger;

    @Override
    public List<Restaurante> find(String nome,
                                  BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){


        var jpql = new StringBuilder();

        var parametros = new HashMap<String, Object>();

        jpql.append("from Restaurante where 0 = 0");

        if (StringUtils.hasLength(nome)){
            jpql.append("and nome like :nome");
            parametros.put("nome", "%" + nome + "%");
        }

        if(taxaFreteInicial != null){
            jpql.append("and taxaFrete >= :taxaInicial");
            parametros.put("taxaIniciale", taxaFreteInicial);
        }

        if(taxaFreteFinal != null){
            jpql.append("and taxaFrete <= :taxaFinal");
            parametros.put("taxaFinal", taxaFreteFinal);
        }

        TypedQuery<Restaurante> query =  maneger.createQuery(jpql.toString(), Restaurante.class);

        parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

        return query.getResultList();
    }

}
