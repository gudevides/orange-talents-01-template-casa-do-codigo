package br.com.zup.casadocodigo.pagamento;

import br.com.zup.casadocodigo.paisestado.cadastraestado.Estado;
import br.com.zup.casadocodigo.paisestado.cadastrapais.Pais;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
public class EstadoPaisValidator implements Validator {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean supports(Class<?> clazz) {
        return PagamentoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (errors.hasErrors()){
            return;
        }

        PagamentoRequest request = (PagamentoRequest) target;

        Pais pais = entityManager.find(Pais.class, request.getIdPais());
        Estado estado;
        if (request.getIdEstado() != null){
            estado = entityManager.find(Estado.class, request.getIdEstado());
            if (!estado.pertencePais(pais)){
                errors.rejectValue("idEstado", null, "Este estado não é do país selecionado!");
            }
        } else if (pais.temEstados(entityManager)){
                errors.rejectValue("idEstado", null, "O país selecionado possui estado(s) cadastrado(s), é necessário informá-lo!");
        }
    }
}
