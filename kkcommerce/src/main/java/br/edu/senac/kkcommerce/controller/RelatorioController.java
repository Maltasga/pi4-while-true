/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Relatorio;
import br.edu.senac.kkcommerce.service.RelatorioService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Karolina G. K.
 */
@Controller
public class RelatorioController extends BaseAdminController {

    RelatorioService service = new RelatorioService();

    @GetMapping("/relatorios")
    public ModelAndView index() throws Exception {
        try {
            return new ModelAndView("relatorio/relatorios.html");
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @PostMapping("/gerar-relatorio")
    public ModelAndView gerarRelatorio(@ModelAttribute("inicio") String inicio, @ModelAttribute("fim") String fim,
            BindingResult bindingResult) throws Exception {
        
        try {
            List<Relatorio> relatorio = service.listarTudo(inicio, fim);
            return new ModelAndView("/relatorio/relatorios.html").addObject("relatorio", relatorio);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
