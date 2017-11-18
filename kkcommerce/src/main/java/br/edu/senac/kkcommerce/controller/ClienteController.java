package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Cliente;
import br.edu.senac.kkcommerce.model.Endereco;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class ClienteController extends BaseLojaController {
    
    @GetMapping("/cadastrar-cliente")
    public ModelAndView inder() {
        return new ModelAndView("cliente/cadastrar")
                .addObject("cliente", new Cliente())
                .addObject("listaUF", Endereco.getUFs());
    }
}
