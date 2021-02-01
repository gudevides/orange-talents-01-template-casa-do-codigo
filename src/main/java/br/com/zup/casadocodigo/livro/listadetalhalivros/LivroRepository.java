package br.com.zup.casadocodigo.livro.listadetalhalivros;

import br.com.zup.casadocodigo.livro.cadastralivro.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    @Query("select new br.com.zup.casadocodigo.livro.listadetalhalivros.ListaLivrosResponse(l.id, l.titulo) from Livro l")
    List<ListaLivrosResponse> findLivros();
}
