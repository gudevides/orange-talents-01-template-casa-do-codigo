package br.com.zup.casadocodigo.categoria.cadastracategoria;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/casadocodigo/categoria")
public class CategoriaController {

    @PersistenceContext
    private EntityManager em;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid CadastraCategoriaRequest form){
        Categoria categoria = form.toModel();

        em.persist(categoria);
    }
}
