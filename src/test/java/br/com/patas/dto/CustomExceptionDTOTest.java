package br.com.patas.dto;

import org.junit.jupiter.api.Test;

import br.com.patas.dto.CustomExceptionDTO;

import static org.junit.jupiter.api.Assertions.*;

class CustomExceptionDTOTest {

    @Test
    void testAllArgsConstructorAndGetter(){
        CustomExceptionDTO dto = new CustomExceptionDTO("testAllArgsConstructorAndGetter");
        assertEquals("testAllArgsConstructorAndGetter", dto.getMessage());
    }

    @Test
    void testSetter(){
        CustomExceptionDTO dto = new CustomExceptionDTO();
        dto.setMessage("testSetter");

        assertEquals("testSetter", dto.getMessage());
    }
}