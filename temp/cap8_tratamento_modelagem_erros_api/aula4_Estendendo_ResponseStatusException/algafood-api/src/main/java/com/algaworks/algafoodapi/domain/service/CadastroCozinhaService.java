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
                    String.format("Cozinha de código: %d não pode ser removida, pois esta em uso", cozinhaId));

        }

        catch (EmptyResultDataAccessException e){

//            Nao precisa do try catch no controller
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
//                    String.format("Não existe cozinha com o códido: %d. Personalizado", cozinhaId));

//            throw new EntidadeNaoEncontradaException(HttpStatus.CONFLICT,
//                    String.format("Não existe cozinha com o códido: %d", cozinhaId));

            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cozinha com o códido: %d - estendido", cozinhaId));
        }
    }
}
