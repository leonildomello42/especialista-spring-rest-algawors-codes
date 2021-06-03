package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafoodapi.domain.model.Cozinha;
import com.algaworks.algafoodapi.domain.repository.CozinhaRepository;
import com.algaworks.algafoodapi.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping(value = "/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id){

        Cozinha cozinha = cozinhaRepository.buscar(id);

        if(cozinha != null){
            return ResponseEntity.ok(cozinha);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {

        Cozinha cozinhaSalva = cadastroCozinhaService.salvar(cozinha);

        return cozinhaSalva;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@RequestBody Cozinha cozinha, @PathVariable Long id) {

        Cozinha cozinhaAtual = cozinhaRepository.buscar(id);

        if(cozinhaAtual != null){

            BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
            cozinhaAtual = cadastroCozinhaService.salvar(cozinhaAtual);

            return ResponseEntity.ok(cozinhaAtual);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {

        try{

            cadastroCozinhaService.excluir(cozinhaId);
            return ResponseEntity.noContent().build();

        }
        catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
    }
}
