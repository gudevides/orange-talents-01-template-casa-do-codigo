package br.com.zup.casadocodigo.autor.cadastraautor;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/casadocodigo/autor")
public class AutorController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid CadastraAutorRequest form){
        Autor autor = form.converter();
        em.persist(autor);
    }
}
