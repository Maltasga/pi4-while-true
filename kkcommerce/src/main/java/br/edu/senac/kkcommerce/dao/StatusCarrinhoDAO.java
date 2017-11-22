/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.StatusCarrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gabri
 */
public class StatusCarrinhoDAO implements IDaoBase<StatusCarrinho> {

    Connection conexao = null;

    @Override
    public List<StatusCarrinho> listar() throws SQLException, Exception {
        ArrayList<StatusCarrinho> status = new ArrayList<>();

        String query = "SELECT * FROM StatusCarrinho";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            StatusCarrinho s = null;
            while (result.next()) {
                s = new StatusCarrinho(
                        result.getInt("ID"),
                        result.getInt("STATUS_ID"),
                        result.getString("STATUS"));
                status.add(s);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return status;
    }

    @Override
    public int inserir(StatusCarrinho obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void atualizar(StatusCarrinho obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public StatusCarrinho getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
