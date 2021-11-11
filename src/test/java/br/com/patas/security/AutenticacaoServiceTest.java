package br.com.patas.security;

import org.junit.jupiter.api.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.patas.entities.Pessoa;
import br.com.patas.security.AutenticacaoService;
import br.com.patas.services.PessoaService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-integrationtest.properties")
@RunWith(SpringRunner.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AutenticacaoServiceTest {

    private PessoaService pessoaService;
    private AutenticacaoService autenticacaoService;

    @Autowired
    public AutenticacaoServiceTest(PessoaService pessoaService, AutenticacaoService autenticacaoService){
        this.pessoaService = pessoaService;
        this.autenticacaoService = autenticacaoService;
    }

    @BeforeAll
    public void setup(){
        Pessoa p = new Pessoa("testeautenticacaoservice", "testeautenticacaoservice@example.com", "cep", "celular", "senha");
        this.pessoaService.save(p);
    }

    @Test
    void loadUserByUsername() {
        UserDetails nome = this.autenticacaoService.loadUserByUsername("testeautenticacaoservice@example.com");
        assertNotNull(nome);
    }

    @Test()
    void loadUserByUsernameNaoExistente() {
        assertThrows(UsernameNotFoundException.class, () -> this.autenticacaoService.loadUserByUsername("teste de nome nao existente"));
    }
}