package br.com.zup.casadocodigo.livro.cadastralivro;

import br.com.zup.casadocodigo.autor.cadastraautor.Autor;
import br.com.zup.casadocodigo.categoria.cadastracategoria.Categoria;
import br.com.zup.casadocodigo.config.validacao.ExistsId;
import br.com.zup.casadocodigo.config.validacao.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class CadastraLivroRequest {

    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "O título informado já está cadastrado!")
    private String titulo;
    @NotBlank @Size(min = 1, max = 500)
    private String resumo;
    private String sumario;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @NotNull @Min(100)
    private int numeroPaginas;
    @NotBlank
    @UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "O ISBN informado já está cadastrado!")
    private String isbn;
    @Future
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataPublicacao;
    @NotNull
    @ExistsId(domainClass = Autor.class, fieldName = "id", message = "ID de Autor não existe no banco")
    private Long idAutor;
    @NotNull
    @ExistsId(domainClass = Categoria.class, fieldName = "id", message = "ID de Categoria não existe no banco")
    private Long idCategoria;

    public CadastraLivroRequest(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, String sumario,
                                @NotNull @Min(20) BigDecimal preco, @NotNull @Min(100) int numeroPaginas,
                                @NotBlank String isbn, @NotNull Long idAutor,
                                @NotNull Long idCategoria) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
        this.isbn = isbn;
        this.idAutor = idAutor;
        this.idCategoria = idCategoria;
    }

    /**
     * Criei esse setter pq o jackson não estava sendo capaz de desserializar o json com a data no parâmetro pelo
     * construtor.Talvez existe um jeito melhor, mas não sei no momento.
     * @param dataPublicacao
     */
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public Livro toModel(EntityManager entityManager) {
        @NotNull Autor autor = entityManager.find(Autor.class, idAutor);
        @NotNull Categoria categoria = entityManager.find(Categoria.class, idCategoria);

        Assert.state(autor!= null, "Você está tentando cadastrar um livro para um autor que não existe no banco -" + idAutor);
        Assert.state(categoria!= null, "Você está tentando cadastrar um livro para uma categoria que não existe no banco -" + idCategoria);

        return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, categoria, autor);
    }
}
