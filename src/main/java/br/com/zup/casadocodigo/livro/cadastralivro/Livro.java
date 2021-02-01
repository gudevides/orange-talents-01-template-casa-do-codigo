package br.com.zup.casadocodigo.livro.cadastralivro;

import br.com.zup.casadocodigo.autor.cadastraautor.Autor;
import br.com.zup.casadocodigo.categoria.cadastracategoria.Categoria;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String titulo;
    @NotBlank @Size(max = 500)
    private String resumo;

    private String sumario;
    @NotNull @Min(20)
    private BigDecimal preco;
    @NotNull @Min(100)
    private Integer numeroPaginas;
    @NotBlank
    private String isbn;
    @Future
    @NotNull
    private LocalDate dataPublicacao;
    @NotNull
    @Valid
    @ManyToOne
    private Categoria categoria;
    @NotNull
    @Valid
    @ManyToOne
    private Autor autor;

    public Livro(String titulo, String resumo, String sumario, BigDecimal preco,
                 Integer numeroPaginas, String isbn, LocalDate dataPublicacao,
                 Categoria categoria, Autor autor) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
        this.categoria = categoria;
        this.autor = autor;
    }

    @Deprecated
    public Livro(){}

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getNumeroPaginas() {
        return numeroPaginas;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
        return autor;
    }
}
