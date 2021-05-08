package com.algaworks.algafood.api.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@Controller
//@ResponseBody // a resposta dos método deve ir para a resposta da requisicao http

@RestController // tem o ResponseBody e o Controller
@RequestMapping(value = "/cozinhas")
public class CozinhaController {

    private CozinhaRepository cozinhaRepository;

    @Autowired
    public CozinhaController(CozinhaRepository cozinhaRepository){
        this.cozinhaRepository = cozinhaRepository;
    }

    @GetMapping
    public List<Cozinha> listar(){
        return cozinhaRepository.listar();
    }
}
