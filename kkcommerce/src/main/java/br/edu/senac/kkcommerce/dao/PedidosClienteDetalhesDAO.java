/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.IDaoBase;
import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.PedidosCliente;
import br.edu.senac.kkcommerce.model.PedidosClienteDetalhes;
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
public class PedidosClienteDetalhesDAO implements IDaoBase<PedidosClienteDetalhes> {

    Connection conexao = null;

    @Override
    public List<PedidosClienteDetalhes> listar() throws SQLException, Exception {
        ArrayList<PedidosClienteDetalhes> pedido = new ArrayList<>();

        String query = "SELECT * FROM SELECT_PEDIDO_CLIENTE_DETALHES";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            PedidosClienteDetalhes p = null;

            while (result.next()) {
                p = new PedidosClienteDetalhes(
                        result.getInt("PRODUTO_ID"),
                        result.getString("NOME_PRODUTO"),
                        result.getDouble("VL_UNITARIO"),
                        result.getString("DESCRICAO"),
                        result.getInt("QUANTIDADE"),
                        result.getString("TAMANHO"),
                        result.getInt("CARRINHO_ID"),
                        Util.toUtilDate(result.getDate("DT_COMPRA")),
                        result.getLong("PROTOCOLO"),
                        result.getString("NOME_CLIENTE"));

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
    public PedidosClienteDetalhes getById(int id) throws SQLException, Exception {
        PedidosClienteDetalhes pedido = new PedidosClienteDetalhes();

        String query = "SELECT * FROM SELECT_PEDIDO_CLIENTE_DETALHES WHERE ID_COMPRA = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            PedidosClienteDetalhes p = null;

            while (result.next()) {
                p = new PedidosClienteDetalhes(
                        result.getInt("PRODUTO_ID"),
                        result.getString("NOME_PRODUTO"),
                        result.getDouble("VL_UNITARIO"),
                        result.getString("DESCRICAO"),
                        result.getInt("QUANTIDADE"),
                        result.getString("TAMANHO"),
                        result.getInt("CARRINHO_ID"),
                        Util.toUtilDate(result.getDate("DT_COMPRA")),
                        result.getLong("PROTOCOLO"),
                        result.getString("NOME_CLIENTE"));

//                pedido.add(p);
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
    public int inserir(PedidosClienteDetalhes obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(PedidosClienteDetalhes obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
