package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

//    List<Cozinha> consultarPorNome(String nome);

    //nome do campo na entidade :nome
    List<Cozinha> nome(String nome);

    //findBy é o prefixo findBy_criterio - findQualquerCoisaBy_criterio
    List<Cozinha> findByNome(String nome);

    Optional<Cozinha> findSingleByNome(String nome);

    //findByNomeContaining
    List<Cozinha> findTodasByNomeContaining(String nome);

    boolean existsByNome(String nome);
}
