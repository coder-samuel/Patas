package br.com.patas.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.patas.dto.CredenciaisDTO;
import br.com.patas.dto.PessoaDTO;
import br.com.patas.dto.TokenDTO;
import br.com.patas.entities.Pessoa;
import br.com.patas.services.PessoaService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/pessoa")
@RequiredArgsConstructor
@CrossOrigin
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@GetMapping()
	public Iterable<Pessoa> getAll(){
		return pessoaService.getAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Pessoa> getById(@PathVariable Integer id){
		return pessoaService.getById(id);
	}
	
	@GetMapping("/email")
	public Optional<Pessoa> getPersonByEmail(@RequestParam String email) {
		return pessoaService.getPersonByEmail(email);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa salvar(@RequestBody br.com.patas.dto.PessoaDTO pessoa) {
		return pessoaService.savePerson(pessoa);
	}

	@PostMapping("/auth")
	public ResponseEntity<TokenDTO> autenticar(@RequestBody CredenciaisDTO credenciais) {
		return pessoaService.authenticatePerson(credenciais);
	}
	
	@PutMapping("/{emailPerson}")
	public Pessoa updatePessoa(@PathVariable String emailPerson,@RequestBody PessoaDTO dataPerson) throws Exception{
		return pessoaService.updatePerson(emailPerson, dataPerson);
	}
	
	@DeleteMapping("/{id}")
	public void deletePessoa(@PathVariable Integer id) {
		pessoaService.deleteById(id);
	}

}
