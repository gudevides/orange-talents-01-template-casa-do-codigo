package br.com.zup.casadocodigo.livro.cadastralivro;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/casadocodigo/livro")
public class CadastraLivroController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid CadastraLivroRequest request){
        Livro livro = request.toModel(entityManager);
        entityManager.persist(livro);
    }

}
