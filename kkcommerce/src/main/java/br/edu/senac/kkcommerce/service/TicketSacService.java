/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.TicketSacDao;
import br.edu.senac.kkcommerce.model.TicketSac;
import java.util.List;

/**
 *
 * @author while true
 */
public class TicketSacService extends ServiceBase {

    public TicketSacService() {
        super(new TicketSacDao());
    }

    public List<TicketSac> listar() throws Exception {
        List<TicketSac> ticketSacs = dao.listar();
        return ticketSacs;
    }

    public void salvar(TicketSac ts) throws Exception {
        if (dao.getById(ts.getId()) == null) {
            int idTicketSac = dao.inserir(ts);
        } else {
            dao.atualizar(ts);
        }
    }

    public TicketSac buscar(int ticketSacId) throws Exception {
        TicketSac ts = (TicketSac) dao.getById(ticketSacId);
        return ts;
    }
}
