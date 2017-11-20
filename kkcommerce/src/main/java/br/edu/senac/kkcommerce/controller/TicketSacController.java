/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.controller;

import br.edu.senac.kkcommerce.model.TicketSac;
import br.edu.senac.kkcommerce.service.TicketSacService;
import java.util.Calendar;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author while_true
 */
@Controller
public class TicketSacController extends BaseLojaController {

    TicketSacService ticketSacService = new TicketSacService();

    @GetMapping("/ticket-sac")
    public ModelAndView index() throws Exception {
        try {
            return new ModelAndView("cliente/ticket-sac")
                    .addObject("ticketSac", new TicketSac());
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @PostMapping("/ticket-sac")
    public ModelAndView index(@ModelAttribute("ticketSac") TicketSac ticketSac,
            BindingResult bindingResult) throws Exception {
        long protocolo = 0;
        try {
            protocolo = Calendar.getInstance().getTimeInMillis();
            ticketSac.setProtocolo(protocolo);
            ticketSacService.salvar(ticketSac);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
        return new ModelAndView("redirect:/loja/meus-tickets");
    }

    @GetMapping("/meus-tickets")
    public ModelAndView listarTickets(@ModelAttribute("id") int id) throws Exception {
        try {
            TicketSac c = ticketSacService.buscar(id);

            return new ModelAndView("cliente/listar-tickets")
                    .addObject("ticketSacId", id);
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
