package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class ProdutoController extends BaseAdminController {

    @GetMapping("/produtos")
    public ModelAndView index() {
        return new ModelAndView("produto/index.html");
    }

    @GetMapping("/cadastrar")
    public ModelAndView cadastrar() {
        return new ModelAndView("produto/cadastro");
    }

    @PostMapping("/cadastrar")
    public ModelAndView cadastrar(@ModelAttribute Produto produto, ModelMap model) {
        return new ModelAndView("redirect:/produtos");
    }
}
