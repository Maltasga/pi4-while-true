/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.PedidosClienteDetalhes;
import br.edu.senac.kkcommerce.service.PedidosClienteDetalhesService;
import br.edu.senac.kkcommerce.service.PedidosClienteService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gabib
 */
public class PedidosClienteDetalhesController extends BaseLojaController {

    PedidosClienteDetalhesService service = new PedidosClienteDetalhesService();

//    @GetMapping("/lista-pedidos")
//    public ModelAndView pedidos() throws Exception{
//        try {
//            return new ModelAndView("loja/pedidos-detalhes.html").addObject("pedidos", service.listar());
//        } catch (Exception e) {
//            throw new Exception(e.getMessage());
//        }
//    }
    @GetMapping("/pedido-detalhes-cliente")
    public ModelAndView detalhePedido(@ModelAttribute("pedido_id") int pedido_id) throws Exception {
        try {

            return new ModelAndView("loja/pedidosClienteDetalhes.html")
                    .addObject("pedido", service.listar(pedido_id));
//                    .addObject("total", total);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
