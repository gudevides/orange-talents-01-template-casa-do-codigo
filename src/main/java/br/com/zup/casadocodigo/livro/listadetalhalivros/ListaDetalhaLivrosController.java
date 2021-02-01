package br.com.zup.casadocodigo.livro.listadetalhalivros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/casadocodigo/livro")
public class ListaDetalhaLivrosController {

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<ListaLivrosResponse> listar (){
        return livroRepository.findLivros();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhaLivroResponse> detalhar (@PathVariable Long id){
        return livroRepository.findById(id)
                .map(value -> ResponseEntity.ok(new DetalhaLivroResponse(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
