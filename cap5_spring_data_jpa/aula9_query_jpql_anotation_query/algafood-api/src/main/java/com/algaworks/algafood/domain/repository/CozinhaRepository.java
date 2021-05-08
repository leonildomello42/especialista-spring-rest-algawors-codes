package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> nome(String nome);
    //List<Cozinha> findByNome(String nome);
    List<Cozinha> find_lista_ByNome(String nome);
    List<Cozinha> find_qualquercoisa_ByNome(String nome);

    Cozinha find_unica_ByNome(String nome);
    Optional<Cozinha> findByNome(String nome);

    List<Cozinha> find_qualquer_ByNomeContainig(String nome);

    boolean existsByNome(String nome);


}
