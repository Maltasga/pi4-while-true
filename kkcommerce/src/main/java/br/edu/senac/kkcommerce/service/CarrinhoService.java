/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.CarrinhoDao;
import br.edu.senac.kkcommerce.dao.IDaoBase;
import br.edu.senac.kkcommerce.model.Carrinho;

/**
 * 
 * @author Karolina G. K.
 */
public class CarrinhoService extends ServiceBase{

    public CarrinhoService() {
        super(new CarrinhoDao());
    }

    public void salvar(Carrinho c) throws Exception{
        
    }
}
