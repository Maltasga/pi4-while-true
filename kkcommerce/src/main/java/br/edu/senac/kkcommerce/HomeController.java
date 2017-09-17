
package br.edu.senac.kkcommerce;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while true
 */

@Controller
public class HomeController {
    
    @RequestMapping("/")
    public ModelAndView index(){
        return new ModelAndView("home/index.html");
    }
}
