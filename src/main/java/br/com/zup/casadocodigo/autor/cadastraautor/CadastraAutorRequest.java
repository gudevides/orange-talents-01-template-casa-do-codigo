package br.com.zup.casadocodigo.autor.cadastraautor;

import br.com.zup.casadocodigo.config.validacao.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class CadastraAutorRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    @UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email já cadastrado no sistema!")
    private String email;

    @NotBlank
    @Size(max = 400)
    private String descricao;

    public CadastraAutorRequest(@NotBlank String nome,
                                @NotBlank @Email String email,
                                @NotBlank @Size(max = 400) String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    public Autor converter() {
        return new Autor(this.nome, this.email, this.descricao);
    }

}
