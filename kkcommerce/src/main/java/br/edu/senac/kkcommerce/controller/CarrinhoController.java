package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Carrinho;
import br.edu.senac.kkcommerce.model.CarrinhoItem;
import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.service.ProdutoService;
import java.io.Serializable;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/checkout")
@Scope("session")
public class CarrinhoController implements Serializable {
    
    ProdutoService service = new ProdutoService();
    
    private Carrinho carrinho = new Carrinho();
    
    @GetMapping("/checkout")
    public ModelAndView index() throws Exception {
        try {
            
            return new ModelAndView("loja/carrinho.html")
                    .addObject("carrinho", carrinho);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @PostMapping("/add-item")
    public ModelAndView addItem(@ModelAttribute("id") int id, @ModelAttribute("qtde") int qtde,
            RedirectAttributes redirectAttributes) {
        try {
            Produto p = service.buscar(id);
            carrinho.addItem(new CarrinhoItem(0, p, qtde));
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return new ModelAndView("redirect:/checkout/checkout");
    }
    
    public Carrinho getCarrinho() {
        return this.carrinho;
    }
    
    public int getQuantidadeItens() {
        int qtde = 0;
        for (CarrinhoItem item : this.carrinho.getItens()) {
            qtde += item.getQuantidade();
        }
        return qtde;
    }
}
