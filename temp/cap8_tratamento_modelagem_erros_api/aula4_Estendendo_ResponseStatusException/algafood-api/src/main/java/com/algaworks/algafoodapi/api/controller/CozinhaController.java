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
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebInputException;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;

    @GetMapping
    public List<Cozinha> listar() {
        return cozinhaRepository.findAll();
    }

    @GetMapping(value = "/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id) {

        Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

        if (cozinha.isPresent()) {
            return ResponseEntity.ok(cozinha.get());
        } else {
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

        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(id);

        if (cozinhaAtual.isPresent()) {

            BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");
            Cozinha cozinhaSalva = cadastroCozinhaService.salvar(cozinhaAtual.get());

            return ResponseEntity.ok(cozinhaSalva);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @DeleteMapping("/{cozinhaId}")
//    public ResponseEntity<?> remover(@PathVariable Long cozinhaId) {
//
//        try{
//            cadastroCozinhaService.excluir(cozinhaId);
//            return ResponseEntity.noContent().build();
//        }
//        catch (EntidadeEmUsoException e){
//            System.out.println(e.getMessage());
//            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//        }
//
//        catch (EntidadeNaoEncontradaException e){
//            System.out.println(e.getMessage());
//
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado - hardcode");
//            return ResponseEntity.notFound().build();
//        }
//    }

    @DeleteMapping("/{cozinhaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {

        cadastroCozinhaService.excluir(cozinhaId);
    }
}
