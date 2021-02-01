package br.com.zup.casadocodigo.paisestado.cadastraestado;

import br.com.zup.casadocodigo.paisestado.cadastrapais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;
    @ManyToOne
    private Pais pais;

    @Deprecated
    public Estado(){}

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    public boolean pertencePais(Pais pais) {
        return this.pais.equals(pais);
    }
}
