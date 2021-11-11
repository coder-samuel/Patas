package br.com.patas.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.patas.entities.Pessoa;



public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
	
	Pessoa findOneByEmail(String email);
    Optional<Pessoa> findByEmail(String email);

}
