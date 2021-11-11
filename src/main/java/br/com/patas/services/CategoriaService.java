package br.com.patas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.patas.dto.CategoriaRequestDTO;
import br.com.patas.entities.Categoria;
import br.com.patas.repositories.CategoriaRepository;
import br.com.patas.services.generics.RestBasicService;

@Service
public class CategoriaService implements RestBasicService<Categoria, CategoriaRequestDTO> {
	
	@Autowired
	CategoriaRepository categoriaRepository;

	@Override
	public Page<Categoria> getAll(Pageable page) {
		return categoriaRepository.findAll(page);
	}

	@Override
	public Optional<Categoria> getById(Integer id) {
		return categoriaRepository.findById(id);
	}

	@Override
	public List<Categoria> getAll() {
		return categoriaRepository.findAll();
	}

	@Override
	public CategoriaRequestDTO save(CategoriaRequestDTO i) {
		categoriaRepository.save(i.build());
		return i;
	}

	@Override
	public void deleteById(Integer id) {
		categoriaRepository.deleteById(id);
	}
}
