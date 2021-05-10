package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

//    List<Cidade> listar();
//    Cidade buscar(Long id);
//    Cidade salvar(Cidade cidade);
//    void remover(Long id);
}
