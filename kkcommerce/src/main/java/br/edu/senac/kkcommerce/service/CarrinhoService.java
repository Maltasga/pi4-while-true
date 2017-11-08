/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.CarrinhoDao;
import br.edu.senac.kkcommerce.dao.CarrinhoItemDao;
import br.edu.senac.kkcommerce.model.Carrinho;
import br.edu.senac.kkcommerce.model.CarrinhoItem;
import java.util.List;

/**
 * 
 * @author Karolina G. K.
 */
public class CarrinhoService extends ServiceBase{

    public CarrinhoService() {
        super(new CarrinhoDao());
    }

    public void salvar(Carrinho c) throws Exception{
        CarrinhoItemDao daoItem = new CarrinhoItemDao();
        int idCarrinho = dao.inserir(c);
        for (CarrinhoItem i : c.getItens()) {
            i.setCarrinhoId(idCarrinho);
            daoItem.inserir(i);
        }
    }
    
    public List<Carrinho> listar() throws Exception {
        return dao.listar();
    }
    
    public void atualizar(Carrinho c) throws Exception {
        dao.atualizar(c);
    }
}
