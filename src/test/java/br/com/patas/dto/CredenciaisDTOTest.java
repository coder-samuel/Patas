package br.com.patas.dto;

import org.junit.jupiter.api.Test;

import br.com.patas.dto.CredenciaisDTO;

import static org.junit.jupiter.api.Assertions.*;

class CredenciaisDTOTest {

    @Test
    void testAllArgsConstructorAndGetter(){
        CredenciaisDTO dto = new CredenciaisDTO("testAllArgsConstructorAndGetter", "testAllArgsConstructorAndGetter");
        assertEquals("testAllArgsConstructorAndGetter", dto.getEmail());
    }

    @Test
    void testSetters(){
        CredenciaisDTO dto = new CredenciaisDTO();
        dto.setEmail("testSetters");
        dto.setSenha("testSetterstestSetters");

        assertEquals("testSetters", dto.getEmail());
    }
}