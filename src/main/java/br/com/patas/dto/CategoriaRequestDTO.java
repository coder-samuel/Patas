package br.com.patas.dto;

import br.com.patas.dto.generics.ObjectDTO;
import br.com.patas.entities.Categoria;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaRequestDTO implements ObjectDTO {

    private String classificacao;

    public Categoria build() {
        return new Categoria()
                .setClassificacao(this.classificacao);
    }

}
