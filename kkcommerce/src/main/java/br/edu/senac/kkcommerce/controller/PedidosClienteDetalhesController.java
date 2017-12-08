/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.PedidosClienteDetalhes;
import br.edu.senac.kkcommerce.service.PedidosClienteDetalhesService;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author While True
 */
@Controller
public class PedidosClienteDetalhesController extends BaseLojaController {

    PedidosClienteDetalhesService service = new PedidosClienteDetalhesService();

    @GetMapping("/pedido-detalhes-cliente")
    public ModelAndView detalhePedido(@ModelAttribute("pedido_id") int pedido_id) throws Exception {
        try {
            double total = 0;
            
            List<PedidosClienteDetalhes> pedido = service.listar(pedido_id);

            for (PedidosClienteDetalhes p : pedido) {
                total += p.getVl_item();
            }
            
            return new ModelAndView("loja/pedidosClienteDetalhes.html")
                    .addObject("pedido", pedido)
                    .addObject("total", total);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
