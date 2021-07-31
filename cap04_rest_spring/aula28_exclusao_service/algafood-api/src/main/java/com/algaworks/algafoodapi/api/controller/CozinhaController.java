package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.api.model.CozinhasXmlWrapper;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    @Autowired
    private CadastroCozinhaService cozinhaService;

    @GetMapping
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }

    @GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
    public CozinhasXmlWrapper listarXml(){
        return new CozinhasXmlWrapper(cozinhaRepository.listar());
    }

    @GetMapping(value = "/{cozinhaId}")
    public ResponseEntity<Cozinha> buscar(@PathVariable("cozinhaId") Long id){

        Cozinha cozinha = cozinhaRepository.buscar(id);

        if(cozinha != null){
            return ResponseEntity.status(HttpStatus.OK).body(cozinha);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cozinha adicionar(@RequestBody Cozinha cozinha){

        return cozinhaService.salvar(cozinha);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha){

        Cozinha cozinhaPesquisada = cozinhaRepository.buscar(id);

        if(cozinhaPesquisada != null){
            BeanUtils.copyProperties(cozinha, cozinhaPesquisada, "id");
            cozinhaRepository.salvar(cozinhaPesquisada);

            return ResponseEntity.ok(cozinhaPesquisada);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Cozinha> remover(@PathVariable Long id){

        try{
            cozinhaService.excluir(id);
            return ResponseEntity.noContent().build();

        }
        catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeEmUsoException e){
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
    }
}
