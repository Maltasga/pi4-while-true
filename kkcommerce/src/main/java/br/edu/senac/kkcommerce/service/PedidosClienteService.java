/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.service;

import br.edu.senac.kkcommerce.dao.IDaoBase;
import br.edu.senac.kkcommerce.dao.PedidosClienteDAO;
import br.edu.senac.kkcommerce.dao.StatusCarrinhoDetalheDAO;
import br.edu.senac.kkcommerce.model.PedidosCliente;
import br.edu.senac.kkcommerce.model.StatusCarrinhoDetalhe;
import java.util.List;

/**
 *
 * @author While True
 */
public class PedidosClienteService extends ServiceBase {

    public PedidosClienteService() {
        super(new PedidosClienteDAO());
    }

    public List<PedidosCliente> listar() throws Exception {
        List<PedidosCliente> pedido = dao.listar();

        return pedido;
    }

//    public void salvar(StatusCarrinhoDetalhe s) throws Exception {
//        dao.inserir(s);
//    }
//    
//    public void atualizarStatus(StatusCarrinhoDetalhe s) throws Exception {
//        dao.atualizar(s);
//    }
}
