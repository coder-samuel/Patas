package br.com.patas.converters;

import org.junit.jupiter.api.Test;

import br.com.patas.converters.AnuncioStatusConverter;
import br.com.patas.enums.AnuncioStatus;

import static org.junit.jupiter.api.Assertions.*;

class AnuncioStatusConverterTest {

    @Test
    void convertToDatabaseColumn() {
        AnuncioStatusConverter converter = new AnuncioStatusConverter();
        String convert = converter.convertToDatabaseColumn(AnuncioStatus.ATIVO);
        assertEquals("Ativo", convert);
    }

    @Test
    void convertToEntityAttribute() {
        AnuncioStatusConverter converter = new AnuncioStatusConverter();
        AnuncioStatus convert = converter.convertToEntityAttribute("Inativo");
        assertEquals(AnuncioStatus.INATIVO, convert);
    }

    @Test
    void convertToDatabaseColumnNull() {
        AnuncioStatusConverter converter = new AnuncioStatusConverter();
        String convert = converter.convertToDatabaseColumn(null);
        assertNull(convert);
    }

    @Test
    void convertToEntityAttributeNull() {
        AnuncioStatusConverter converter = new AnuncioStatusConverter();
        AnuncioStatus convert = converter.convertToEntityAttribute(null);
        assertNull(convert);
    }
}