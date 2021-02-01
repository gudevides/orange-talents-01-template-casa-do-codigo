package br.com.zup.casadocodigo.paisestado.cadastrapais;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CadastraPaisRequest {

    @NotBlank
    @UniqueValue(domainClass = Pais.class, fieldName = "nome", message = "País de mesmo nome já cadastrado!")
    private String nome;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CadastraPaisRequest(@NotBlank String nome) {
        this.nome = nome;
    }

    public Pais toMode() {
        return new Pais(nome);
    }
}
