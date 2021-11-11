package br.com.patas.dto;

import org.junit.jupiter.api.Test;

import br.com.patas.dto.CategoriaRequestDTO;
import br.com.patas.entities.Categoria;

import static org.junit.jupiter.api.Assertions.*;

class CategoriaRequestDTOTest {

    @Test
    void testAllArgsConstructorAndGetter(){
        CategoriaRequestDTO c = new CategoriaRequestDTO("testAllArgsConstructorAndGetter");
        assertEquals("testAllArgsConstructorAndGetter", c.getClassificacao());
    }

    @Test
    void testSetter(){
        CategoriaRequestDTO dto = new CategoriaRequestDTO();
        dto.setClassificacao("testSetter");

        assertEquals("testSetter", dto.getClassificacao());
    }

    @Test
    void testBuild(){
        CategoriaRequestDTO dto = new CategoriaRequestDTO("testBuild");
        Categoria build = dto.build();
        assertEquals("testBuild", build.getClassificacao());
    }
}