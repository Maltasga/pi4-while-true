package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class AdminController extends BaseAdminController {

    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("admin/index.html");
    }

    @GetMapping("/entrar")
    public ModelAndView login(Model model) {
        model.addAttribute("user", new Usuario());
        return new ModelAndView("admin/login.html");
    }

    @PostMapping("/entrar")
    public ModelAndView login(@ModelAttribute Usuario usuario, ModelMap model) {
        if ("123".equals(usuario.getSenha())) {
            return new ModelAndView("redirect:/kk-admin/");
        } else {
            model.addAttribute("user", usuario);
            model.addAttribute("msg", "Usuário e/ou senha inválidos");
            return new ModelAndView("admin/login.html");
        }
    }
}
