package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Restaurante;
import com.algaworks.algafoodapi.domain.repository.RestauranteRepository;
import com.algaworks.algafoodapi.domain.service.CadastroCozinhaService;
import com.algaworks.algafoodapi.domain.service.CadastroRestauranteService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroRestauranteService cadastroRestauranteService;

    @GetMapping
    public List<Restaurante> listar(){

        return restauranteRepository.listar();
    }

    @GetMapping("/{restauranteId}")
    public ResponseEntity<Restaurante> buscarId(@PathVariable Long restauranteId){

        Restaurante restaurante = restauranteRepository.buscar(restauranteId);

        if (restaurante != null){

            return ResponseEntity.ok(restaurante);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody Restaurante restaurante){

        try {
            restaurante = cadastroRestauranteService.salvar(restaurante);
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(restaurante);
        }
        catch (EntidadeNaoEncontradaException e) {
            
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{retauranteId}")
    public ResponseEntity<?> atualizar(@PathVariable Long retauranteId, @RequestBody Restaurante restaurante){

        try{

            Restaurante restaurantePersistido = restauranteRepository.buscar(retauranteId);

            if(restaurantePersistido != null){

                BeanUtils.copyProperties(restaurante, restaurantePersistido, "id");
                restaurantePersistido = cadastroRestauranteService.salvar(restaurantePersistido);

                return ResponseEntity.ok(restaurantePersistido);
            }
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}