/*
* Controller utilizada apensar para simular um carrinho de compras
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Carrinho;
import org.springframework.stereotype.Controller;
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
    public ModelAndView checkout2() {
        Carrinho c = Carrinho.getCarrinhoMock();

        return new ModelAndView("tdm/checkoutE2").addObject("valorTotal", c.getValorTotal());
    }
}
