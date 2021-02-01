package br.com.zup.casadocodigo.categoria.cadastracategoria;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CadastraCategoriaRequest {

    @NotBlank
    @UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Categoria já cadastrada no sistema!")
    private String nome;

    public String getNome() {
        return nome;
    }

    public Categoria toModel() {
        return new Categoria(this.nome);
    }
}
