package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Cliente;
import br.edu.senac.kkcommerce.model.Endereco;
import br.edu.senac.kkcommerce.service.ClienteService;
import br.edu.senac.kkcommerce.service.EnderecoService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author while true
 */
@Controller
public class ClienteController extends BaseLojaController {

    ClienteService clienteService = new ClienteService();
    EnderecoService enderecoService = new EnderecoService();

    @GetMapping("/meus-dados")
    public ModelAndView meusDados(@ModelAttribute("id") Integer id) throws Exception {
        try {
            if (id == null || id <= 0) {
                return new ModelAndView("redirect:/loja");
            }

            return new ModelAndView("cliente/meus-dados")
                    .addObject("cliente", clienteService.buscar(id));
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping("/cadastrar-cliente")
    public ModelAndView cadastrarCliente(@ModelAttribute("id") Integer id) throws Exception {
        try {
            Cliente c = new Cliente();
            if (id != null || id > 0) {
                c = clienteService.buscar(id);
            }

            return new ModelAndView("cliente/cadastrar-cliente")
                    .addObject("cliente", c)
                    .addObject("listaUF", Endereco.getUFs());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @PostMapping("/cadastrar-cliente")
    public ModelAndView cadastrarCliente(@ModelAttribute("cliente") Cliente cliente,
            BindingResult bindingResult,
            RedirectAttributes redirectAttrs) throws Exception {
        try {
            int clienteId = clienteService.salvar(cliente);
            redirectAttrs.addFlashAttribute("id", clienteId);

        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return new ModelAndView("redirect:/loja/meus-enderecos");
    }

    @GetMapping("/meus-enderecos")
    public ModelAndView listarEnderecos(@ModelAttribute("id") int id) throws Exception {
        try {
            Cliente c = clienteService.buscar(id);

            return new ModelAndView("cliente/listar-enderecos")
                    .addObject("clienteId", id)
                    .addObject("enderecos", c.getEnderecos());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping("/cadastrar-endereco")
    public ModelAndView cadastrarEndereco(@RequestParam("id") Integer id,
            @RequestParam("eid") Integer eid) throws Exception {
        Endereco endereco;
        try {
            if (eid != null) {
                endereco = enderecoService.buscarPorId(eid);
            } else {
                endereco = new Endereco();
                endereco.setClienteId(id);
            }
            return new ModelAndView("cliente/cadastrar-endereco")
                    .addObject("endereco", endereco)
                    .addObject("listaUF", Endereco.getUFs())
                    .addObject("clienteId", endereco.getClienteId());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @PostMapping("/cadastrar-endereco")
    public ModelAndView cadastrarEndereco(@ModelAttribute("endereco") Endereco endereco,
            BindingResult bindingResult,
            RedirectAttributes redirectAttrs) throws Exception {
        try {
            enderecoService.salvar(endereco);
            redirectAttrs.addFlashAttribute("id", endereco.getClienteId());
            return new ModelAndView("redirect:/loja/meus-enderecos");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @PostMapping("/set-principal-address")
    @ResponseBody
    public String setEnderecoPrincipal(@ModelAttribute("id") int id,
            @ModelAttribute("clienteId") int clienteId) throws Exception {
        try {
            enderecoService.atualizaEnderecoPrincipal(id, clienteId);
            return "ok";
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
