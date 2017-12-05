/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.PedidosCliente;
import br.edu.senac.kkcommerce.model.StatusCarrinhoDetalhe;
import br.edu.senac.kkcommerce.model.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabib
 */
public class PedidosClienteDAO implements IDaoBase<PedidosCliente> {

    Connection conexao = null;

    @Override
    public List<PedidosCliente> listar() throws SQLException, Exception {
        ArrayList<PedidosCliente> pedido = new ArrayList<>();

        String query = "SELECT * FROM SELECT_PEDIDO_CLIENTE";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            PedidosCliente p = null;
            while (result.next()) {
                p = new PedidosCliente(
                        result.getInt("CARRINHO_ID"),
                        result.getLong("PROTOCOLO"),
                        Util.toUtilDate(result.getDate("DT_COMPRA")),
                        result.getInt("CLIENTE_ID"),
                        result.getString("STATUS"),
                        Util.toUtilDate(result.getDate("DT_ATUALIZACAO_STATUS")));
                        
                pedido.add(p);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return pedido;
    }

    @Override
    public int inserir(PedidosCliente obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(PedidosCliente obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidosCliente getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
