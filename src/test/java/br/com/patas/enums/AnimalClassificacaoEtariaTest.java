package br.com.patas.enums;

import org.junit.jupiter.api.Test;

import br.com.patas.enums.AnimalClassificacaoEtaria;

import static org.junit.jupiter.api.Assertions.*;

class AnimalClassificacaoEtariaTest {

    @Test
    void getDescricao() {
        AnimalClassificacaoEtaria classificacaoEtaria = AnimalClassificacaoEtaria.ADULTO;
        assertEquals("Adulto", classificacaoEtaria.getDescricao());
    }

    @Test
    void of() {
        AnimalClassificacaoEtaria classificacaoEtaria = AnimalClassificacaoEtaria.of("Adulto");
        assertEquals(AnimalClassificacaoEtaria.ADULTO, classificacaoEtaria);
    }

    @Test
    void values() {
        AnimalClassificacaoEtaria[] values = AnimalClassificacaoEtaria.values();
        assertTrue(values.length > 0);
    }

    @Test
    void valueOf() {
        AnimalClassificacaoEtaria classificacaoEtaria = AnimalClassificacaoEtaria.valueOf("ADULTO");
        assertEquals(AnimalClassificacaoEtaria.ADULTO, classificacaoEtaria);
    }
}