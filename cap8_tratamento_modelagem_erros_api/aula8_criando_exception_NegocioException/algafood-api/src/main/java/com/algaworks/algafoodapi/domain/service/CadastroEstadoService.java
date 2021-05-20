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
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroEstadoService {

    public static final String MSG_ESTADO_NAO_ENCONTRADO = "Não existe estado com o códido: %d";
    public static final String MSG_ESTADO_EM_USO = "Estado de código: %d não pode ser removida, pois esta em uso";
    @Autowired
    private EstadoRepository estadoRepository;

    @Transactional
    public Estado salvar(Estado estado){

        Estado estadoPersistido = estadoRepository.save(estado);
        return estadoPersistido;
    }

    @Transactional
    public void excluir(Long id){

        try{
            estadoRepository.deleteById(id);
        }

        catch (DataIntegrityViolationException e){
            throw new EntidadeEmUsoException(
                    String.format(MSG_ESTADO_EM_USO, id));
        }

        catch (EmptyResultDataAccessException e){
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_ESTADO_NAO_ENCONTRADO, id));
        }
    }

    public Estado buscarOuFalhar(Long id){

        return estadoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format(MSG_ESTADO_NAO_ENCONTRADO, id)));
    }
}
