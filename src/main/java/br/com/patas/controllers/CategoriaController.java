package br.com.patas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patas.controllers.generics.RestBasicController;
import br.com.patas.dto.CategoriaRequestDTO;
import br.com.patas.entities.Categoria;
import br.com.patas.services.CategoriaService;


@RestController
@RequestMapping(path = "categoria")
public class CategoriaController extends RestBasicController<Categoria, CategoriaRequestDTO> {

	CategoriaService categoriaService;

	@Autowired
	public CategoriaController(CategoriaService service) {
		super(service);
		this.categoriaService = service;
	}
}
