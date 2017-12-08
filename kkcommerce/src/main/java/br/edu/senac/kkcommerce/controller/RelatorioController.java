/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.Categoria;
import br.edu.senac.kkcommerce.model.Relatorio;
import br.edu.senac.kkcommerce.service.CategoriaService;
import br.edu.senac.kkcommerce.service.RelatorioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RelatorioController extends BaseAdminController {

    private RelatorioService service = new RelatorioService();
    private CategoriaService catService = new CategoriaService();

    @GetMapping("/relatorios")
    public ModelAndView index(@ModelAttribute("inicio") String inicio, @ModelAttribute("fim") String fim) throws Exception {
        try {

            List<Categoria> categorias = catService.listar();
            List<Categoria> catFem = new ArrayList<>();
            List<Categoria> catMasc = new ArrayList<>();

            for (Categoria c : categorias) {
                if (c.getGenero().equals("F")) {
                    catFem.add(c);
                } else {
                    catMasc.add(c);
                }
            }
            List<Relatorio> relatorio = service.listarTudo(inicio, fim);
            return new ModelAndView("relatorio/relatorios.html")
                    .addObject("catfem", catFem)
                    .addObject("catmasc", catMasc)
                    .addObject("relatorio", relatorio);
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
