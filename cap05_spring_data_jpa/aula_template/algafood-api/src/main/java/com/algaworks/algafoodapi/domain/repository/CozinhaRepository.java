package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {


//    Apagar
//    List<Cozinha> listar();
//    Cozinha buscar(Long id);
//    Cozinha salvar(Cozinha cozinha);
//    void remover(Long id);

    //aula

//    List<Cozinha> consultarPorNome(String nome);
}
