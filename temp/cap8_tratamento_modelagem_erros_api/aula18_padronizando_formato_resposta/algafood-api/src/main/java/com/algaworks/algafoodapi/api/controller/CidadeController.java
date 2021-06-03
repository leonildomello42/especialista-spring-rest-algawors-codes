package com.algaworks.algafoodapi.api.controller;

import com.algaworks.algafoodapi.domain.exception.EstadoNaoEncontradoException;
import com.algaworks.algafoodapi.domain.exception.NegocioException;
import com.algaworks.algafoodapi.domain.model.Cidade;
import com.algaworks.algafoodapi.domain.repository.CidadeRepository;
import com.algaworks.algafoodapi.domain.service.CadastroCidadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private CadastroCidadeService cadastroCidade;

    @GetMapping
    public List<Cidade> listar() {
        return cidadeRepository.findAll();
    }

    @GetMapping("/{cidadeId}")
    public Cidade buscar(@PathVariable Long cidadeId) {
        return cadastroCidade.buscarOuFalhar(cidadeId);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cidade adicionar(@RequestBody Cidade cidade) {

        try{
            return cadastroCidade.salvar(cidade);
        }
        catch (EstadoNaoEncontradoException e){
            throw new NegocioException(e.getMessage(), e);
        }
    }


    @PutMapping("/{cidadeId}")
    public Cidade atualizar(@PathVariable Long cidadeId,
                            @RequestBody Cidade cidade) {
        try{
            Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);
            BeanUtils.copyProperties(cidade, cidadeAtual, "id");
            return cadastroCidade.salvar(cidadeAtual);
        }
        catch (EstadoNaoEncontradoException e){
            throw new NegocioException(e.getMessage(), e);
        }
    }

    @DeleteMapping("/{cidadeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long cidadeId) {
        cadastroCidade.excluir(cidadeId);
    }

//    @ExceptionHandler(EntidadeNaoEncontradaException.class)
//    public ResponseEntity<?> tratarEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e){
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//    }
//
//    @ExceptionHandler(NegocioException.class)
//    public ResponseEntity<?> tratarNegocioException(NegocioException e){
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
//    }

//    @ExceptionHandler(EntidadeNaoEncontradaException.class)
//    public ResponseEntity<?> tratarEntidadeNaoEncontradaException(EntidadeNaoEncontradaException e){
//
//        Problema problema = new Problema(LocalDateTime.now(), e.getMessage());
//
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(problema);
//    }
//
//    @ExceptionHandler(NegocioException.class)
//    public ResponseEntity<?> tratarNegocioException(NegocioException e){
//
//        Problema problema = new Problema(LocalDateTime.now(), e.getMessage());
//
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(problema);
//    }


}
