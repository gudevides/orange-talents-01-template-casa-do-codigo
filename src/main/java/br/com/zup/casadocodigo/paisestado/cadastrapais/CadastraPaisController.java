package br.com.zup.casadocodigo.paisestado.cadastrapais;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/casadocodigo/pais")
public class CadastraPaisController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid CadastraPaisRequest request){
        Pais pais = request.toMode();
        entityManager.persist(pais);
    }
}
