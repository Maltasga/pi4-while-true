package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Estoque;
import br.edu.senac.kkcommerce.model.ImagemProduto;
import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.model.Promocao;
import br.edu.senac.kkcommerce.service.ColecaoService;
import br.edu.senac.kkcommerce.service.FileService;
import br.edu.senac.kkcommerce.service.MarcaService;
import br.edu.senac.kkcommerce.service.ProdutoService;
import br.edu.senac.kkcommerce.service.PromocaoService;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author while true
 */
@Controller
public class ProdutoController extends BaseAdminController {

    ProdutoService produtoService = new ProdutoService();
    PromocaoService promocaoService = new PromocaoService();

    @GetMapping("/listar-produtos")
    public ModelAndView index() throws Exception {
        try {
            return new ModelAndView("produto/index.html")
                    .addObject("produtos", produtoService.listar());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping(value = {"/cadastrar-produto", "/editar-cadastro-produto"})
    public ModelAndView cadastrar(@ModelAttribute("id") Integer id, Model model) throws Exception {
        MarcaService marcaService = new MarcaService();
        ColecaoService colecaoService = new ColecaoService();

        Produto produtoModel = new Produto();

        if (id != null && id > 0) {
            produtoModel = produtoService.buscar(id);
        }
        produtoModel.setEstoque(Estoque.getRelacaoEstoque());
        model.addAttribute("produto", produtoModel);
        try {
            model.addAttribute("estoque", produtoModel.getEstoque());
            model.addAttribute("marcas", marcaService.listar());
            model.addAttribute("colecoes", colecaoService.listar());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return new ModelAndView("produto/cadastro");
    }

    @PostMapping("/cadastrar-produto")
    public ModelAndView cadastrar(@ModelAttribute("produto") Produto produto,
            BindingResult bindingResult) throws Exception {
        try {
            ArrayList<ImagemProduto> imagens = FileService.gravarArquivos(produto.getArquivos());
            produto.setImagens(imagens);
            produtoService.salvar(produto);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return new ModelAndView("redirect:/kk-admin/listar-produtos");
    }

    @GetMapping("/manutencao-desconto")
    public ModelAndView manutencaoDesconto(@ModelAttribute("id") Integer id) throws Exception {
        try {
            ArrayList<Promocao> promos = promocaoService.listar(id);
            Promocao promoModel = new Promocao();
            promoModel.setProdutoId(id == null ? 0 : id);
            return new ModelAndView("produto/desconto")
                    .addObject("promocaoModel", promoModel)
                    .addObject("promocoes", promos);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @PostMapping("/manutencao-desconto")
    public ModelAndView manutencaoDesconto(@ModelAttribute("promocaoModel") Promocao promocao,
            RedirectAttributes redirectAttrs) throws Exception {

        try {
            promocaoService.salvar(promocao);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }

        redirectAttrs.addFlashAttribute("id", promocao.getProdutoId());
        return new ModelAndView("redirect:/kk-admin/manutencao-desconto");
    }

    @PostMapping("/encerrar-promocao")
    @ResponseBody
    public String encerrarPromocao(@ModelAttribute("id") Integer id) throws Exception {
        try {
            promocaoService.encerrar(id);
            return "ok";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return "Falha ao encerrar promoção cadastrada.";
        }
    }

}
