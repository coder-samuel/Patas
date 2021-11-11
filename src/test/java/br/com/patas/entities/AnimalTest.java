package br.com.patas.entities;

import org.junit.jupiter.api.Test;

import br.com.patas.entities.Animal;
import br.com.patas.entities.Especie;
import br.com.patas.entities.Foto;
import br.com.patas.enums.AnimalClassificacaoEtaria;
import br.com.patas.enums.AnimalPorte;
import br.com.patas.enums.AnimalSexo;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    @Test
    void allArgsConstructorAndGetter() {
        Foto f = new Foto();
        Especie e = new Especie();
        Animal a = new Animal(1,
                AnimalSexo.MACHO, AnimalClassificacaoEtaria.ADULTO, AnimalPorte.PEQUENO, true,
                true, "animal", "00000-000", "logradouro", "complemento",
                "bairro", "localidade", "uf", "ibge", "ddd", e, f);

        assertEquals(1,a.getIdAnimal());
        assertEquals(AnimalSexo.MACHO,a.getSexo());
        assertEquals(AnimalClassificacaoEtaria.ADULTO,a.getClassificacaoEtaria());
        assertEquals(AnimalPorte.PEQUENO,a.getPorte());
        assertEquals(true, a.getCastrado());
        assertEquals(true, a.getVacinado());
        assertEquals("animal",a.getNome());
        assertEquals("00000-000", a.getCep());
        assertEquals("logradouro",a.getLogradouro());
        assertEquals("complemento", a.getComplemento());
        assertEquals("bairro", a.getBairro());
        assertEquals("localidade", a.getLocalidade());
        assertEquals("uf", a.getUf());
        assertEquals("ibge", a.getIbge());
        assertEquals("ddd", a.getDdd());
        assertEquals(e, a.getEspecie());
        assertEquals(f, a.getFotos());
    }

    @Test
    void minimalConstructor() {
        Animal a = new Animal(AnimalSexo.MACHO, AnimalClassificacaoEtaria.ADULTO, AnimalPorte.PEQUENO,
                true, true, "00000-000");
        assertEquals("00000-000", a.getCep());
    }
}