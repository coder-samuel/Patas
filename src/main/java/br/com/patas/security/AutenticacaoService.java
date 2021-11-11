package br.com.patas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.patas.entities.Pessoa;
import br.com.patas.services.PessoaService;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    private PessoaService service;

    @Autowired
    public AutenticacaoService(@Lazy PessoaService service){
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<Pessoa> p = service.getPersonByEmail(username);

        if (p.isPresent()) {
            return p.get();
        }

        throw new UsernameNotFoundException("Dados inválidos!");
    }

}