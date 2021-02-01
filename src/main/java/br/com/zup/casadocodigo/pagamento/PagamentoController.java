package br.com.zup.casadocodigo.pagamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/casadocodigo/pagamento")
public class PagamentoController {

        @Autowired
        private EstadoPaisValidator estadoPaisValidator;

        @InitBinder
        public void init(WebDataBinder binder){
            binder.addValidators(estadoPaisValidator);
        }

        @PostMapping
        public String pagamento(@RequestBody @Valid PagamentoRequest request){
            return request.toString();
        }

}
