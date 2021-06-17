package com.algaworks.algafoodapi.domain.repository;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha buscarId(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Cozinha cozinha);

}
