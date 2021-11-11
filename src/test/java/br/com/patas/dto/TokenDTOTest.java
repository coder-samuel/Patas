package br.com.patas.dto;

import org.junit.jupiter.api.Test;

import br.com.patas.dto.TokenDTO;

import static org.junit.jupiter.api.Assertions.*;

class TokenDTOTest {

    @Test
    void testAllArgsConstructorAndGetter(){
        TokenDTO dto = new TokenDTO("testAllArgsConstructorAndGetter", "testAllArgsConstructorAndGetter");
        assertEquals("testAllArgsConstructorAndGetter", dto.getToken());
        assertEquals("testAllArgsConstructorAndGetter", dto.getEmail());
    }

    @Test
    void testSetter(){
        TokenDTO dto = new TokenDTO();
        dto.setToken("testSetter");
        dto.setEmail("testSetter");

        assertEquals("testSetter", dto.getEmail());
        assertEquals("testSetter", dto.getToken());
    }
}