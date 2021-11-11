package br.com.patas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.patas.entities.Categoria;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
