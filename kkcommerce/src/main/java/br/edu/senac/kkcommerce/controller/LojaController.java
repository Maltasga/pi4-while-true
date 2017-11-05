package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class LojaController {

    ProdutoService produtoService = new ProdutoService();
    
    @GetMapping("")
    public ModelAndView index() throws Exception {
        try {
            return new ModelAndView("loja/index.html")
                    .addObject("produtos", produtoService.listar());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @GetMapping("/detalhes-produto")
    public ModelAndView detalhes(@ModelAttribute("id") int id) throws Exception {
        try {
            return new ModelAndView("loja/detalhesProduto.html")
                    .addObject("produto", produtoService.buscar(id));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
