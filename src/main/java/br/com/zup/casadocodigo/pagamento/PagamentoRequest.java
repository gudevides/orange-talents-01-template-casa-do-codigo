package br.com.zup.casadocodigo.pagamento;

import br.com.zup.casadocodigo.config.validacao.CPFouCNPJ;
import br.com.zup.casadocodigo.config.validacao.ExistsId;
import br.com.zup.casadocodigo.paisestado.cadastraestado.Estado;
import br.com.zup.casadocodigo.paisestado.cadastrapais.Pais;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PagamentoRequest {

    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @NotBlank
    @CPFouCNPJ
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Não existe país com o Id informado!")
    private Long idPais;
    @ExistsId(domainClass = Estado.class, fieldName = "id", message = "Não existe estado com o Id informado!")
    private Long idEstado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public PagamentoRequest(@NotBlank @Email String email, @NotBlank String nome, @NotBlank String sobrenome,
                            @NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento, @NotBlank String cidade,
                            @NotBlank Long idPais, @NotBlank Long idEstado, @NotBlank String telefone, @NotBlank String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.idPais = idPais;
        this.idEstado = idEstado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Long getIdPais() {
        return idPais;
    }

    public Long getIdEstado() {
        return idEstado;
    }

    @Override
    public String toString() {
        return "PagamentoRequest{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", documento='" + documento + '\'' +
                ", endereco='" + endereco + '\'' +
                ", complemento='" + complemento + '\'' +
                ", cidade='" + cidade + '\'' +
                ", idPais=" + idPais +
                ", idEstado=" + idEstado +
                ", telefone='" + telefone + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }
}
