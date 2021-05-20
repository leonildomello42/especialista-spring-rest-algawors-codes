package com.algaworks.algafoodapi.domain.service;

import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Restaurante salvar(Restaurante restaurante){

        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                String.format("Não existe cadastro de cozinha com o código %d", cozinhaId)));


        restaurante.setCozinha(cozinha);
        return restauranteRepository.save(restaurante);
    }

//    public Restaurante salvar(Restaurante restaurante){
//
//        Long cozinhaId = restaurante.getCozinha().getId();
//        Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
//
//        if(cozinha.isEmpty()){
//            throw new EntidadeNaoEncontradaException(
//                    String.format("Não existe cadastro de cozinha com o código %d", cozinhaId));
//        }
//
//        restaurante.setCozinha(cozinha.get());
//        return restauranteRepository.salvar(restaurante);
//    }
}
