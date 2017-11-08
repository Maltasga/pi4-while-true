/*
* Controller utilizada apensar para simular um carrinho de compras
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Carrinho;
import br.edu.senac.kkcommerce.model.Checkout;
import br.edu.senac.kkcommerce.model.Endereco;
import br.edu.senac.kkcommerce.service.CarrinhoService;
import br.edu.senac.kkcommerce.service.EnderecoService;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author while true
 */
@Controller
@RequestMapping("/tdm-checkout")
public class TDMCarrinhoController {

    @GetMapping("/carrinho")
    public ModelAndView checkout() {
        Carrinho carrinho = Carrinho.getCarrinhoMock();

        return new ModelAndView("tdm/checkout")
                .addObject("carrinho", carrinho);
    }

    @GetMapping("/carrinho-e2")
    public ModelAndView checkout2(Model model) {
        Carrinho c = Carrinho.getCarrinhoMock();
        Checkout checkoutModel = new Checkout();
        checkoutModel.setClienteId(1);

        model.addAttribute("listaUF", Endereco.getUFs());
        model.addAttribute("checkout", checkoutModel);
        model.addAttribute("valorTotal", c.getValorTotal());

        return new ModelAndView("tdm/checkoutE2");
    }

    @PostMapping("/carrinho-e2")
    public ModelAndView checkout2(@ModelAttribute("checkout") Checkout checkout,
            BindingResult bindingResult,
            RedirectAttributes redirectAttrs) throws Exception {
        try {
            CarrinhoService carrService = new CarrinhoService();
            EnderecoService enderecoService = new EnderecoService();

            Carrinho carrinho = Carrinho.getCarrinhoMock();
            carrinho.setClienteId(checkout.getClienteId());
            carrinho.setFormaPgto(checkout.getFormaPgto());

            Endereco end = checkout.getEndereco();
            end.setClienteId(checkout.getClienteId());

            enderecoService.salvar(end);
            carrService.salvar(carrinho);
            
            long protocolo = Calendar.getInstance().getTimeInMillis();
            
            carrinho.setProtocolo(protocolo);
            carrService.atualizar(carrinho);
            
            redirectAttrs.addFlashAttribute("protocolo", protocolo);
            redirectAttrs.addFlashAttribute("tkey", "1984");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return new ModelAndView("redirect:/tdm-checkout/carrinho-e3");
    }

    @GetMapping("/carrinho-e3")
    public ModelAndView checkout3(@ModelAttribute("tkey") String tkey,
            @ModelAttribute("protocolo") String prot) {
        ModelAndView mv = new ModelAndView("tdm/checkoutE3");
        if (tkey == null || "".equals(tkey)) {
            mv.addObject("alerta", "Acesso não autorizado!");
        } else {
            mv.addObject("alerta", null);
        }
        mv.addObject("protocolo", prot);

        return mv;
    }

    @ResponseBody
    @PostMapping("/calc-frete")
    public String calcularFrete(@RequestParam("cep") String cep) {
        Random r = new Random();
        double randomValue = 0 + (73.50) * r.nextDouble();
        if (randomValue == 0) {
            return "Frete gratuito";
        }
        DecimalFormat dFormat = new DecimalFormat("#.00");
        return "Frete R$ " + dFormat.format(randomValue);
    }
}
