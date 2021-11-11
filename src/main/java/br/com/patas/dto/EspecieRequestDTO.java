package br.com.patas.dto;


import br.com.patas.dto.generics.ObjectDTO;
import br.com.patas.entities.Especie;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EspecieRequestDTO implements ObjectDTO {
	
	private String nome;
	
	public Especie build() {
		return new Especie()
				.setNome(this.nome);
	}

}
