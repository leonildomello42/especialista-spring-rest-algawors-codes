package com.algaworks.algafood.domain.repository;

import com.algaworks.algafood.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

//    List<Estado> listar();
//    Estado buscar(Long id);
//    Estado salvar(Estado estado);
//    void remover(Long id);
}
