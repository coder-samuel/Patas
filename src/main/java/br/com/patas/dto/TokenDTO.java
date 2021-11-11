package br.com.patas.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {
	private String email;
	private String token;
	
}