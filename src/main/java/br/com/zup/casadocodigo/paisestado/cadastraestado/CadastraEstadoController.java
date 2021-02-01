package br.com.zup.casadocodigo.paisestado.cadastraestado;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/casadocodigo/estado")
public class CadastraEstadoController {

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid CadastraEstadoRequest request){
        Estado estado = request.toModel(entityManager);
        entityManager.persist(estado);
    }
}
