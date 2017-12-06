/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.PedidosClienteDetalhesDAO;
import br.edu.senac.kkcommerce.dao.IDaoBase;
import br.edu.senac.kkcommerce.model.PedidosClienteDetalhes;
import java.util.ArrayList;

import java.util.List;

/**
 *
 * @author While True
 */

public class PedidosClienteDetalhesService extends ServiceBase {

    public PedidosClienteDetalhesService() {
        super(new PedidosClienteDetalhesDAO());
    }

    public List<PedidosClienteDetalhes> listar(int carrinho_id) throws Exception {
        ArrayList<PedidosClienteDetalhes> retorno = new ArrayList<>();
        ArrayList<PedidosClienteDetalhes> pedido = (ArrayList<PedidosClienteDetalhes>) dao.listar();
        
         for (PedidosClienteDetalhes p : pedido) {
            if (p.getCarrinho_id()== carrinho_id) {
                retorno.add(p);
            }
        }
        return retorno;
    }

}
