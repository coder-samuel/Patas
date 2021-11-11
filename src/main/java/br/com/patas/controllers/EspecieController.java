package br.com.patas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patas.controllers.generics.RestBasicController;
import br.com.patas.dto.EspecieRequestDTO;
import br.com.patas.entities.Especie;
import br.com.patas.services.EspecieService;

@RestController
@RequestMapping(path = "especie")
public class EspecieController extends RestBasicController<Especie, EspecieRequestDTO> {

    @Autowired
    EspecieService especieService;

    @Autowired
    public EspecieController(EspecieService service) {
        super(service);
        this.especieService = service;
    }

}
