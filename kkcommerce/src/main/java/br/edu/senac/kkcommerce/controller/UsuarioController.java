package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Usuario;
import br.edu.senac.kkcommerce.service.PerfilService;
import br.edu.senac.kkcommerce.service.UsuarioService;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class UsuarioController extends BaseAdminController {

    UsuarioService usuarioService = new UsuarioService();
    PerfilService perfilService = new PerfilService();

    @GetMapping("/listar-usuarios")
    public ModelAndView index() throws Exception {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            return new ModelAndView("usuario/index.html")
                    .addObject("usuario", usuarioService.listar());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @GetMapping("/cadastrar-usuario")
    public ModelAndView cadastrar(Model model) {
        ModelAndView mv = new ModelAndView("usuario/cadastro");
        try {
            mv.addObject("usuario", new Usuario());
            mv.addObject("perfis", perfilService.listar());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return mv;
    }

    @PostMapping("/cadastrar-usuario")
    public ModelAndView cadastrar(@ModelAttribute("usuario") Usuario usuario,
            BindingResult bindingResult) throws Exception {
        try {
            usuarioService.salvar(usuario);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return new ModelAndView("redirect:/kk-admin/listar-usuarios");
    }
}
