package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.dao.CarrinhoDao;
import br.edu.senac.kkcommerce.model.DetalhePedido;
import br.edu.senac.kkcommerce.model.StatusCarrinhoDetalhe;
import br.edu.senac.kkcommerce.service.StatusCarrinhoService;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author gabri
 */
@Controller
public class StatusCarrinhoController extends BaseAdminController {
    
    StatusCarrinhoService statusService = new StatusCarrinhoService();
    
    @GetMapping("/statusPedidos")
    public ModelAndView index() throws Exception {
        try {
            return new ModelAndView("Pedido/StatusPedidos.html")
                    .addObject("status", statusService.listar());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @GetMapping("/detalhePedido")
    public ModelAndView detalhePedido(@ModelAttribute("pedido_id") int pedido_id) throws Exception {
        try {
            CarrinhoDao dao = new CarrinhoDao();
            ArrayList<DetalhePedido> listaPedidos = dao.listaDetalhe(pedido_id);
            double total = 0;
            for (DetalhePedido item : listaPedidos) {
                total += item.getValorTotal();
            }
            
            return new ModelAndView("Pedido/DetalhePedido.html")
                    .addObject("detalheCompra", listaPedidos)
                    .addObject("total", total);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @PostMapping("/AlterarStatusCarrinho")
    @ResponseBody
    public String setStatusCarrinho(@ModelAttribute("carrinho_id") int carrinho_id,
            @ModelAttribute("status_id") int status_id) throws Exception {
        try {
            StatusCarrinhoDetalhe status = new StatusCarrinhoDetalhe();
            Date date = new Date();
            status.setCarrinho_id(carrinho_id);
            status.setStatus_id(status_id);
            status.setDt_cadastro(date);
            
            statusService.atualizarStatus(status);
            return "ok";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
