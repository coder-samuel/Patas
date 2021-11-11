package br.com.patas.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.patas.entities.Animal;



public interface AnimalRepository extends CrudRepository<Animal, Integer>{
	
}