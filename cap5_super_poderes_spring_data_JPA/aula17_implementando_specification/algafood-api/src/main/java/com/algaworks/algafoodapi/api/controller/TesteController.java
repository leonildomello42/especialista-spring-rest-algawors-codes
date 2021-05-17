package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteComFreteGratisSpec;
import com.algaworks.algafoodapi.infrastructure.repository.spec.RestauranteComNomeSemelhanteSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private RestauranteRepository restauranteRepository;

    @GetMapping("/cozinhas/por-nome")
    public List<Cozinha> cozinhasPorNome(@RequestParam String nome){

        return cozinhaRepository.findByNome(nome);
    }

    @GetMapping("/cozinhas/unico-por-nome")
    public Cozinha cozinhaPorNome(@RequestParam String nome){

        Optional<Cozinha> cozinha = cozinhaRepository.findUmaCozinhaByNome(nome);
        return cozinha.get();
    }

    @GetMapping("/cozinhas/por-nome-contendo")
    public List<Cozinha> cozinhasPorNomeContendo(@RequestParam String nome){

        return cozinhaRepository.findByNomeContaining(nome);
    }

    @GetMapping("/restaurantes/por-taxa-frete")
    public List<Restaurante> restaurantesPoTaxaFrete(@RequestParam BigDecimal taxaInicial, @RequestParam BigDecimal taxaFinal){

        return restauranteRepository.findByTaxaFreteBetween(taxaInicial, taxaFinal);
    }

    @GetMapping("/restaurantes/por-nome")
    public List<Restaurante> restaurantesPorTaxaFrete(String nome, Long cozinhaId) {

        return restauranteRepository.findByNomeContainingAndCozinhaId(nome, cozinhaId);
    }

    @GetMapping("/restaurantes/por-nome-e-frete")
    public List<Restaurante> restaurantesPorNomeFrete(String nome,
                                                      BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
        return restauranteRepository.find(nome, taxaFreteInicial, taxaFreteFinal);
    }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> restaurantesComFreteGratis(String nome) {
        var comFreteGratis = new RestauranteComFreteGratisSpec();
        var comNomeSemelhante = new RestauranteComNomeSemelhanteSpec(nome);

        return restauranteRepository.findAll(comFreteGratis.and(comNomeSemelhante));
    }
}
