package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CadastroCozinhaService {

    public static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe cozinha com o códido: %d - metodo";
    public static final String MSG_COZINHA_EM_USO = "Cozinha de código: %d não pode ser removida, pois esta em uso";

    @Autowired
    CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha){

        return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long cozinhaId){

        try {
            cozinhaRepository.deleteById(cozinhaId);
        }
        catch (DataIntegrityViolationException e){

            throw new EntidadeEmUsoException(
                    String.format(MSG_COZINHA_EM_USO, cozinhaId));

        }

        catch (EmptyResultDataAccessException e){

            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));
        }
    }

    public Cozinha buscarOuFalhar(Long id){

        return cozinhaRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format(MSG_COZINHA_NAO_ENCONTRADA, id)));
    }
}
