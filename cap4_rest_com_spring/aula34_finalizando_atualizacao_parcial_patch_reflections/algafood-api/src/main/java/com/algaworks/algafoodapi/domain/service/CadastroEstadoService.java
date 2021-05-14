package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Estado;
import com.algaworks.algafoodapi.domain.repository.EstadoRepository;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){

        Estado estadoPersistido = estadoRepository.salvar(estado);
        return estadoPersistido;
    }

    public void excluir(Long id){

        try{
            estadoRepository.remover(id);
        }

        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código: %d não pode ser removida, pois esta em uso", id));
        }

        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cozinha com o códido: %d", id));
        }
    }
}
