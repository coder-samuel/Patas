package br.com.patas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.patas.dto.MensagemDTO;
import br.com.patas.entities.Mensagem;
import br.com.patas.entities.Pessoa;
import br.com.patas.repositories.MensagemRepository;
import br.com.patas.repositories.PessoaRepository;
import br.com.patas.services.generics.RestBasicService;

@Service
public class MensagemService implements RestBasicService<Mensagem, MensagemDTO> {

	private MensagemRepository mensagemRepository;

	private PessoaRepository pessoaRepository;

	@Autowired
	public MensagemService(MensagemRepository mensagemRepository, PessoaRepository pessoaRepository) {
		this.mensagemRepository = mensagemRepository;
		this.pessoaRepository = pessoaRepository;
	}

	@Override
	public List<Mensagem> getAll() {
		return (List<Mensagem>) mensagemRepository.findAll();
	}

	@Override
	public Page<Mensagem> getAll(Pageable page) {
		return mensagemRepository.findAll(page);
	}

	@Override
	public Optional<Mensagem> getById(Integer id) {
		return mensagemRepository.findById(id);
	}

	@Override
	public MensagemDTO save(MensagemDTO i) {
		return null;
	}

	public Mensagem save(Mensagem message){
		Optional<Pessoa> pessoa = pessoaRepository.findByEmail(message.getIdPessoa().getEmail());
		if(pessoa.isPresent()) {
			Integer pessoaId = pessoa.get().getIdPessoa();
			message.getIdPessoa().setIdPessoa(pessoaId);
		}
		mensagemRepository.save(message);
		return message;
	}
	
	public Mensagem updateMessage(Integer idMessage, Mensagem dataMessage) throws Exception{
		Mensagem messageToUpdate = mensagemRepository.findById(idMessage)
				.orElseThrow(()-> new IllegalAccessException());
		
		if(!dataMessage.getMsgConteudo().isEmpty()) messageToUpdate.setMsgConteudo(dataMessage.getMsgConteudo());
		
		mensagemRepository.save(messageToUpdate);
		return messageToUpdate;
	}
	
	public void deleteMessage(Integer id) {
		mensagemRepository.deleteById(id);
	} 

	@Override
	public void deleteById(Integer id) {
		this.mensagemRepository.deleteById(id);
	}
}
