package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> nome(String nome);

    List<Cozinha> findTodasByNome(String nome);

    Cozinha findUmaByNome(String nome);

    //find_world_ByNome
    Optional<Cozinha> findUmaOptionalByNome(String nome);

    List<Cozinha> findTodasByNomeContaining(String nome);

    boolean existsByNome(String nome);


}
