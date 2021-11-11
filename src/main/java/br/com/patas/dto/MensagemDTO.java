package br.com.patas.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

import br.com.patas.dto.generics.ObjectDTO;
import br.com.patas.entities.Anuncio;
import br.com.patas.entities.Mensagem;
import br.com.patas.entities.Pessoa;

@NoArgsConstructor
@AllArgsConstructor
public class MensagemDTO implements ObjectDTO {

    private Integer idMensagem;
    private Date dataMensagem;
    private String mensagem;
    private Pessoa idPessoa;
    private Anuncio idAnuncio;

    @Override
    public Mensagem build() {
        return new Mensagem();
    }
}
