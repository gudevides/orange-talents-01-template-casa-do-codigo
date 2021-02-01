package br.com.zup.casadocodigo.paisestado.cadastraestado;

import br.com.zup.casadocodigo.config.validacao.ExistsId;
import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import br.com.zup.casadocodigo.paisestado.cadastrapais.Pais;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;

public class CadastraEstadoRequest {

    @NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Estado de nome já cadastrado!")
    private String nome;
    @ExistsId(domainClass = Pais.class, fieldName = "id", message = "Não existe um país com o Id informado")
    private Long idPais;

    public CadastraEstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    public Estado toModel(EntityManager entityManager) {
        return new Estado(nome, entityManager.find(Pais.class, idPais));
    }
}
