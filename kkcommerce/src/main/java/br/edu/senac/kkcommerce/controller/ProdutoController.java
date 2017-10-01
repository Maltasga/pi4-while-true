package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.service.ColecaoService;
import br.edu.senac.kkcommerce.service.MarcaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/listar-produtos")
    public ModelAndView index() {
        return new ModelAndView("produto/index.html");
    }

    @GetMapping("/cadastrar-produto")
    public ModelAndView cadastrar(Model model) {
        MarcaService marcaService = new MarcaService();
        ColecaoService colecaoService = new ColecaoService();

        try {
            model.addAttribute("marcas", marcaService.listar());
            model.addAttribute("colecoes", colecaoService.listar());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ModelAndView("produto/cadastro");
    }

    @PostMapping("/cadastrar-produto")
    public ModelAndView cadastrar(@ModelAttribute Produto produto, ModelMap model) {

        return new ModelAndView("redirect:/listar-produtos");
    }
}