package br.com.patas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.patas.dto.EspecieRequestDTO;
import br.com.patas.entities.Especie;
import br.com.patas.repositories.EspecieRepository;
import br.com.patas.services.generics.RestBasicService;

@Service
public class EspecieService implements RestBasicService<Especie, EspecieRequestDTO> {
	
	@Autowired
	EspecieRepository especieRepository;

	@Override
	public List<Especie> getAll() {
		return (List<Especie>) especieRepository.findAll();
	}

	@Override
	public Page<Especie> getAll(Pageable page) {
		return especieRepository.findAll(page);
	}

	@Override
	public Optional<Especie> getById(Integer id) {
		return especieRepository.findById(id);
	}

	@Override
	public EspecieRequestDTO save(EspecieRequestDTO i) {
		especieRepository.save(i.build());
		return i;
	}

	@Override
	public void deleteById(Integer id) {
		especieRepository.deleteById(id);
	}
}
