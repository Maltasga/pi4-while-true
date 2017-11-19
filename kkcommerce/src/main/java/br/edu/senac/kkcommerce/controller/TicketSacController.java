/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.service.TicketSacService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while_true
 */
@Controller
public class TicketSacController {

    TicketSacService service = new TicketSacService();

    @GetMapping("/ticket-sac")
    public ModelAndView index() throws Exception {
        try {
            return new ModelAndView("usuario/ticketSac.html")
                    .addObject("ticketSacs", service.listar());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
