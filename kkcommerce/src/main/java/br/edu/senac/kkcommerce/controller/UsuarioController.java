package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Usuario;
import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class UsuarioController extends BaseAdminController {

    @GetMapping("/listar-usuarios")
    public ModelAndView index() throws Exception {
        try {
            ArrayList<Usuario> usuarios = new ArrayList<>();
            return new ModelAndView("usuario/index.html")
                    .addObject("usuario", usuarios);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
