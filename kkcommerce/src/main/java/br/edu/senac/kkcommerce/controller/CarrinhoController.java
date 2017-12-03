package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Carrinho;
import br.edu.senac.kkcommerce.model.CarrinhoItem;
import br.edu.senac.kkcommerce.model.Estoque;
import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.model.StatusCarrinhoDetalhe;
import br.edu.senac.kkcommerce.service.CarrinhoService;
import br.edu.senac.kkcommerce.service.EstoqueService;
import br.edu.senac.kkcommerce.service.ProdutoService;
import br.edu.senac.kkcommerce.service.StatusCarrinhoService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Scope("session")
public class CarrinhoController extends BaseLojaController implements Serializable {

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
    @ResponseBody()
    public ModelAndView addItem(@ModelAttribute("id") int id, @ModelAttribute("qtde") int qtde, @ModelAttribute("tamanho") String tam,
            RedirectAttributes redirectAttributes) {
        try {
            Produto p = service.buscar(id);
            carrinho.addItem(new CarrinhoItem(0, p, qtde, tam));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return new ModelAndView("redirect:/loja/checkout");
    }

    @PostMapping("/finalizar-compra")
    @ResponseBody()
    public long finalizarCompra(@ModelAttribute("strCarrinho") String strCarrinho) throws Exception {
        long protocolo = 0;
        int carrinhoID;
        try {
            ArrayList<CarrinhoItem> arrAuxiliar = new ArrayList<>();
            CarrinhoService carrService = new CarrinhoService();
            StatusCarrinhoService statusService = new StatusCarrinhoService();
            
            protocolo = Calendar.getInstance().getTimeInMillis();
            carrinho.setProtocolo(protocolo);
            carrinho.setClienteId(1);
            carrinho.setFormaPgto(1);

            Gson gson = new Gson();
            arrAuxiliar = gson.fromJson(strCarrinho, new TypeToken<ArrayList<CarrinhoItem>>() {
            }.getType());
//          for que compara o ID do produto do carrinho(preenchido pela sessão) 
//          com o id do produto recuperado diretamente do carrinho via ajax (array)
//          para atualizar a quantidade
            for (CarrinhoItem item : carrinho.getItens()) {
                for (CarrinhoItem itemAux : arrAuxiliar) {
                    if (itemAux.getId() == item.getProduto().getId()) {
                        item.setQuantidade(itemAux.getQuantidade());
                    }
                }
            }
            //Salva os dados
            carrinhoID = carrService.salvar(carrinho);
            
            //Insere status do pedido
            StatusCarrinhoDetalhe status = new StatusCarrinhoDetalhe();
            status.setCarrinho_id(carrinhoID);
            status.setStatus_id(1);// Status 1 = Pendente de pgt
            
            statusService.salvar(status);// Insere status do pedido
            
            //Remove do estoque
              for (CarrinhoItem item : carrinho.getItens()) {
                  int produtoID = item.getProduto().getId();
                  String tamanho = item.getTamanho();
                  int qtd = item.getQuantidade();
                  Estoque estoque = new Estoque(0, produtoID,tamanho,qtd);
                  EstoqueService eservice = new EstoqueService();
                  
                  eservice.atualizarEstoque(estoque);
            }
            
            //Limpa o carrinho
            carrinho = new Carrinho();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return protocolo;
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
