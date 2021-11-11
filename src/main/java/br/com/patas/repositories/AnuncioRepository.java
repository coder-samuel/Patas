package br.com.patas.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.patas.entities.Anuncio;
import br.com.patas.enums.AnimalClassificacaoEtaria;
import br.com.patas.enums.AnimalPorte;
import br.com.patas.enums.AnimalSexo;


public interface AnuncioRepository extends JpaRepository<Anuncio, Integer>, JpaSpecificationExecutor<Anuncio>{
	
	Page<Anuncio> findByIdAnimalSexo(AnimalSexo sexo, Pageable pageable);
	Page<Anuncio> findByIdAnimalEspecieIdEspecie(Integer id, Pageable pageable);
	Page<Anuncio> findByIdCategoriaIdCategoria(Integer id, Pageable pageable);
	Page<Anuncio> findByIdAnimalClassificacaoEtaria(AnimalClassificacaoEtaria classificacaoEtaria, Pageable pageable);
	Page<Anuncio> findByIdAnimalPorte(AnimalPorte porte, Pageable pageable);
	List<Anuncio> findByIdAnimalSexoAndIdAnimalPorte(AnimalSexo sexo, AnimalPorte porte);
	Page<Anuncio> findByidPessoaEmail(String email, Pageable pageable);

}
