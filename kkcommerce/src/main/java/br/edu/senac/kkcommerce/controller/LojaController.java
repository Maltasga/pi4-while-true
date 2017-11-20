package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.service.ProdutoService;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class LojaController extends BaseLojaController {

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
            ArrayList<Double> parcelas = new ArrayList<>();

            ModelAndView model = new ModelAndView("loja/detalhesProduto.html");
            Produto produto = produtoService.buscar(id);
            model.addObject("produto", produto);

            for (int i = 1; i < 6; i++) {
                parcelas.add(produto.getValor() / i);
            }
            model.addObject("parcelas", parcelas);
            
            return model;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
    @GetMapping("/protocolo")
    public ModelAndView protocolo() throws Exception {
        try {
            return new ModelAndView("loja/protocolo.html");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
