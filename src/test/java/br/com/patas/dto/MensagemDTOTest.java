package br.com.patas.dto;

import org.junit.jupiter.api.Test;

import br.com.patas.dto.MensagemDTO;
import br.com.patas.entities.Anuncio;
import br.com.patas.entities.Mensagem;
import br.com.patas.entities.Pessoa;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MensagemDTOTest {

    @Test
    void testAllArgsConstructor(){
        MensagemDTO mensagem = new MensagemDTO(1, new Date(), "mensagem", new Pessoa(), new Anuncio());
        assertNotNull(mensagem);
    }

    @Test
    void testNoArgsConstructor(){
        MensagemDTO mensagemDTO = new MensagemDTO();
        assertNotNull(mensagemDTO);
    }

    @Test
    void testBuid(){
        MensagemDTO mensagemDTO = new MensagemDTO();
        Mensagem build = mensagemDTO.build();
        assertNotNull(build);
        assertTrue(build instanceof Mensagem);
    }
}