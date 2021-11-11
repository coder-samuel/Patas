package br.com.patas.specification;

import org.springframework.data.jpa.domain.Specification;

import br.com.patas.entities.Anuncio;
import br.com.patas.enums.AnimalClassificacaoEtaria;
import br.com.patas.enums.AnimalPorte;
import br.com.patas.enums.AnimalSexo;
import br.com.patas.enums.AnuncioStatus;

import java.text.MessageFormat;

public class AnuncioSpecification {

    public static final String ID_ANIMAL = "idAnimal";

    public Specification<Anuncio> statusFilter(AnuncioStatus status) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("status"), status);
    }

    public Specification<Anuncio> animalSexoFilter(AnimalSexo sexo) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.join(ID_ANIMAL).get("sexo"), sexo);
    }

    public Specification<Anuncio> animalPorteFilter(AnimalPorte porte) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.join(ID_ANIMAL).get("porte"), porte);
    }

    public Specification<Anuncio> animalClassificacaoEtariaFilter(AnimalClassificacaoEtaria classificacaoEtaria) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.join(ID_ANIMAL).get("classificacaoEtaria"), classificacaoEtaria);
    }

    public Specification<Anuncio> animalCepFilter(String cep) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.like(root.join(ID_ANIMAL).get("cep"), contains(cep));
    }

    private String contains(String expression) {
        return MessageFormat.format("{0}%", expression);
    }

    public Specification<Anuncio> anuncioCategoriaFilter(Integer idCategoria) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.join("idCategoria").get("idCategoria"), idCategoria);
    }

    public Specification<Anuncio> animalEspecieFilter(Integer idEspecie) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.join(ID_ANIMAL).get("especie"), idEspecie);
    }

    public Specification<Anuncio> animalVacinadoFilter(Boolean vacinado) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.join(ID_ANIMAL).get("vacinado"), vacinado);
    }

    public Specification<Anuncio> animalCastradoFilter(Boolean castrado) {
        return (root, criteriaQuery, criteriaBuilder) ->
                criteriaBuilder.equal(root.join(ID_ANIMAL).get("castrado"), castrado);
    }


}
