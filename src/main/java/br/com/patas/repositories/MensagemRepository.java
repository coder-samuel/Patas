package br.com.patas.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.patas.entities.Mensagem;

public interface MensagemRepository extends PagingAndSortingRepository<Mensagem, Integer> {

}