package br.com.zup.casadocodigo.paisestado.cadastrapais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;

    @Deprecated
    public Pais(){}

    public Pais(@NotBlank String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(id, pais.id) && Objects.equals(nome, pais.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
