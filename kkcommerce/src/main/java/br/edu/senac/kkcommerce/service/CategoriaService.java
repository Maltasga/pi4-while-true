/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.CategoriaDao;
import br.edu.senac.kkcommerce.model.Categoria;
import java.util.List;

/**
 *
 * @author Karolina
 */
public class CategoriaService extends ServiceBase {

    public CategoriaService() {
        super(new CategoriaDao());
    }

    public List<Categoria> listar() throws Exception {
        return dao.listar();
    }
}
