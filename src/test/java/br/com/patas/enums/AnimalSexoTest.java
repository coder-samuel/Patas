package br.com.patas.enums;

import org.junit.jupiter.api.Test;

import br.com.patas.enums.AnimalSexo;

import static org.junit.jupiter.api.Assertions.*;

class AnimalSexoTest {

    @Test
    void getDescricao() {
        AnimalSexo animal = AnimalSexo.MACHO;
        assertEquals("Macho", animal.getDescricao());
    }

    @Test
    void of() {
        AnimalSexo animal = AnimalSexo.of("Macho");
        assertEquals(AnimalSexo.MACHO, animal);
    }

    @Test
    void values() {
        AnimalSexo[] values = AnimalSexo.values();
        assertTrue(values.length > 0);
    }

    @Test
    void valueOf() {
        AnimalSexo animal = AnimalSexo.valueOf("FEMEA");
        assertEquals(AnimalSexo.FEMEA, animal);
    }
}