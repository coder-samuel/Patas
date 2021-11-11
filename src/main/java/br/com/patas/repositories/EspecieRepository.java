package br.com.patas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.patas.entities.Especie;


public interface EspecieRepository extends PagingAndSortingRepository<Especie, Integer> {

}