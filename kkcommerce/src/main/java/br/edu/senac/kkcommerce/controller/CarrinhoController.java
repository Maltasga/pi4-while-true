package br.edu.senac.kkcommerce.controller;

import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("checkout")
@Scope("session")
public class CarrinhoController implements Serializable{

    @GetMapping("/checkout")
    public ModelAndView index() throws Exception {
        try {
            return new ModelAndView("loja/carrinho.html")
                    .addObject("produtos", produtoService.listar());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
