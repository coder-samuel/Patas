package br.com.patas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.patas.entities.Anuncio;
import br.com.patas.enums.AnimalClassificacaoEtaria;
import br.com.patas.enums.AnimalPorte;
import br.com.patas.enums.AnimalSexo;
import br.com.patas.enums.AnuncioStatus;
import br.com.patas.services.AnuncioService;

import java.util.Optional;

@RestController
@RequestMapping(path = "/anuncio")
@CrossOrigin
public class AnuncioController {
	
	@Autowired
	private AnuncioService anuncioService;
	
	@GetMapping("/busca")
	public Iterable<Anuncio> getFilteredAnnounce(Pageable pageable, String cep, AnuncioStatus status, AnimalSexo sexo,
			AnimalPorte porte, AnimalClassificacaoEtaria classificacaoEtaria, Integer idCategoria, Integer idEspecie,
			Boolean castrado, Boolean vacinado) {
		return anuncioService.getFilteredAnnounce(pageable, cep, status, sexo, porte, classificacaoEtaria, idCategoria,
				idEspecie, castrado, vacinado);
	}
	
	@GetMapping("/{id}")
	public Optional<Anuncio> getAnnounceById(@PathVariable Integer id) {
		return anuncioService.getAnnounceById(id);
	}

	@GetMapping("/pessoa")
	public Page<Anuncio> getAnnounceByEmailPessoa(@RequestParam String email, Pageable pageable) {
		return anuncioService.getAnnounceByEmailPessoa(email, pageable);
	}
	
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Anuncio addAnnounce(@RequestBody Anuncio anuncio) {
		return anuncioService.save(anuncio);
	}

	@PutMapping("atualizastatus/{idAnuncio}")
	public Anuncio updateStatusAnnounce(@PathVariable Integer idAnuncio)  {
		return anuncioService.updateStatusAnnounce(idAnuncio);
	}
	
	@DeleteMapping("/{id}")
	public void deleteAnnounce(@PathVariable Integer id) {
		anuncioService.deleteAnnounce(id);
	}
}
