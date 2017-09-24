package br.edu.senac.kkcommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */
@Controller
public class LojaController {

    @GetMapping("")
    public ModelAndView index() {
        return new ModelAndView("loja/index");
    }
}
