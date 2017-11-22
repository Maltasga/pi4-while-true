package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.StatusCarrinhoDetalhe;
import br.edu.senac.kkcommerce.service.StatusCarrinhoService;
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
    
    @PostMapping("/AlterarStatusCarrinho")
    @ResponseBody
    public String setStatusCarrinho(@ModelAttribute("carrinho_id") int carrinho_id,
            @ModelAttribute("status_id") int status_id) throws Exception {
        try {
            StatusCarrinhoDetalhe status = new StatusCarrinhoDetalhe();
            
            status.setCarrinho_id(carrinho_id);
            status.setStatus_id(status_id);
            
            statusService.salvar(status);
            return "ok";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
    
}