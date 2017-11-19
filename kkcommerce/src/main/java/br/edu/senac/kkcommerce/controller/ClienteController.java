package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Cliente;
import br.edu.senac.kkcommerce.model.Endereco;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class ClienteController extends BaseLojaController {

    @GetMapping("/cadastrar-cliente")
    public ModelAndView index() {
        return new ModelAndView("cliente/cadastrar")
                .addObject("cliente", new Cliente())
                .addObject("listaUF", Endereco.getUFs());
    }

    @PostMapping("/cadastrar-cliente")
    public ModelAndView index(@ModelAttribute("cliente") Cliente cliente,
            BindingResult bindingResult) throws Exception {
        try {
            System.out.println("cliente OK");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return new ModelAndView("redirect:/loja");
    }
}
