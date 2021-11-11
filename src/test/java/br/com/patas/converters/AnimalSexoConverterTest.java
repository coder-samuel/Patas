package br.com.patas.converters;

import org.junit.jupiter.api.Test;

import br.com.patas.converters.AnimalSexoConverter;
import br.com.patas.enums.AnimalSexo;

import static org.junit.jupiter.api.Assertions.*;

class AnimalSexoConverterTest {

    @Test
    void convertToDatabaseColumn() {
        AnimalSexoConverter converter = new AnimalSexoConverter();
        String s = converter.convertToDatabaseColumn(AnimalSexo.MACHO);
        assertEquals("Macho", s);
    }

    @Test
    void convertToEntityAttribute() {
        AnimalSexoConverter converter = new AnimalSexoConverter();
        AnimalSexo convert = converter.convertToEntityAttribute("Macho");
        assertEquals(AnimalSexo.MACHO, convert);
    }

    @Test
    void convertToDatabaseColumnNull() {
        AnimalSexoConverter converter = new AnimalSexoConverter();
        String s = converter.convertToDatabaseColumn(null);
        assertNull(s);
    }

    @Test
    void convertToEntityAttributeNull() {
        AnimalSexoConverter converter = new AnimalSexoConverter();
        AnimalSexo convert = converter.convertToEntityAttribute(null);
        assertNull(convert);
    }
}