/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.ContatoDao;
import br.edu.senac.kkcommerce.model.Contato;
import java.util.List;

/**
 *
 * @author while true
 */
public class ContatoService extends ServiceBase {

    public ContatoService() {
        super(new ContatoDao());
    }

    public List<Contato> listar() throws Exception {
        return dao.listar();
    }

    public List<Contato> listar(int id) throws Exception {
        ContatoDao contatoDao = new ContatoDao();
        return contatoDao.listar(id);
    }

    public void atualizar(Contato c) throws Exception {
        dao.atualizar(c);
    }

}
