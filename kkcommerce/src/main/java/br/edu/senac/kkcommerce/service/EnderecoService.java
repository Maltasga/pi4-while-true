/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.EnderecoDao;
import br.edu.senac.kkcommerce.model.Endereco;

/**
 * 
 * @author Karolina G. K.
 */
public class EnderecoService extends ServiceBase{

    public EnderecoService(){
        super(new EnderecoDao());
    }
    
    public void salvar(Endereco e) throws Exception{
        dao.inserir(e);
    }
}
