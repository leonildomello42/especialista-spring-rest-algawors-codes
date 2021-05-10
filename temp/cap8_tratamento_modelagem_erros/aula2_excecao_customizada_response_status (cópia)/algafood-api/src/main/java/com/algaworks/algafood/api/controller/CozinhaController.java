package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.service.CadastroCozinhaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    public CadastroCozinhaService cadastroCozinha;

    @GetMapping
    public List<Cozinha> listar() {

        return cozinhaRepository.findAll();
    }

    @GetMapping(value = "/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable(value = "cozinhaId") long id){

        Optional<Cozinha> cozinha = cozinhaRepository.findById(id);

        if(cozinha.isPresent()){

            return ResponseEntity.ok(cozinha.get());
        }
        else {

            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha) {
        return cadastroCozinha.salvar(cozinha);
    }

    @PutMapping("/{cozinhaId}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId,
                                             @RequestBody Cozinha cozinha) {
        Optional<Cozinha> cozinhaAtual = cozinhaRepository.findById(cozinhaId);

        if (cozinhaAtual.isPresent()) {
            BeanUtils.copyProperties(cozinha, cozinhaAtual.get(), "id");

            Cozinha cozinhaSalva = cadastroCozinha.salvar(cozinhaAtual.get());
            return ResponseEntity.ok(cozinhaSalva);
        }
        return ResponseEntity.notFound().build();
    }

//    @DeleteMapping("/{cozinhaId}")
//    public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId) {
//
//        try {
//            cadastroCozinha.excluir(cozinhaId);
//            return ResponseEntity.noContent().build();
//
//        }
//        catch (EntidadeNaoEncontradaException e) {
//
//            return ResponseEntity.notFound().build();
//            //return ResponseEntity.status(HttpStatus.NOT_FOUND).body("mensagem");
//        }
//        catch (EntidadeEmUsoException e) {
//            return ResponseEntity.status(HttpStatus.CONFLICT).build();
//        }
//    }

    @DeleteMapping("/{cozinhaId}")
    //@ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cozinhaId) {
        cozinhaRepository.deleteById(cozinhaId);
    }
}
