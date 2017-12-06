/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.service.CarrinhoService;
import br.edu.senac.kkcommerce.service.PedidosClienteService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author While True
 */
@Controller
public class PedidosController extends BaseLojaController{

    PedidosClienteService service = new PedidosClienteService();
    
    @GetMapping("/lista-pedidos")
    public ModelAndView pedidos() throws Exception{
        try {
            return new ModelAndView("loja/pedidos.html").addObject("pedidos", service.listar());
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
}
