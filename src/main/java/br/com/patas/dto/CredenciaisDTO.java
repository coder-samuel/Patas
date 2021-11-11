package br.com.patas.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CredenciaisDTO {
	private String email;
	private String senha;
}