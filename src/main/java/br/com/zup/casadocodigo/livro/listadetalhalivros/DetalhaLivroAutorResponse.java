package br.com.zup.casadocodigo.livro.listadetalhalivros;

import br.com.zup.casadocodigo.autor.cadastraautor.Autor;

public class DetalhaLivroAutorResponse {

    private String nome;
    private String descricao;

    public DetalhaLivroAutorResponse(Autor autor) {
        this.nome = autor.getNome();
        this.descricao = autor.getDescricao();
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }
}
