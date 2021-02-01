package br.com.zup.casadocodigo.categoria.cadastracategoria;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String nome;

    public Categoria(){ }

    public Categoria(@NotBlank String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
