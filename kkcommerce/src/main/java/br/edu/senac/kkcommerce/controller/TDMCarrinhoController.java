/*
* Controller utilizada apensar para simular um carrinho de compras
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Carrinho;
import br.edu.senac.kkcommerce.model.Endereco;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
@RequestMapping("/tdm-checkout")
public class TDMCarrinhoController {
    
    @RequestMapping("/carrinho")
    public ModelAndView checkout() {
        Carrinho carrinho = Carrinho.getCarrinhoMock();
        
        return new ModelAndView("tdm/checkout")
                .addObject("carrinho", carrinho);
    }
    
    @RequestMapping("/carrinho-e2")
    public ModelAndView checkout2(Model model) {
        Carrinho c = Carrinho.getCarrinhoMock();
        
        model.addAttribute("endereco", new Endereco());
        model.addAttribute("valorTotal", c.getValorTotal());
        
        return new ModelAndView("tdm/checkoutE2");
    }
}
