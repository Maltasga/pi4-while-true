/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.PerfilDao;
import br.edu.senac.kkcommerce.model.Perfil;
import java.util.List;

/**
 *
 * @author gabri
 */
public class PerfilService extends ServiceBase {

    public PerfilService() {
        super(new PerfilDao());
    }

    public List<Perfil> listar() throws Exception {
        return dao.listar();
    }

    public Perfil buscar(int id) throws Exception {
        return (Perfil) dao.getById(id);
    }
}