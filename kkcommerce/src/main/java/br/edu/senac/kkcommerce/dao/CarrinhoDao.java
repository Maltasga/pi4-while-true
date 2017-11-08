/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Carrinho;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karolina G. K.
 */
public class CarrinhoDao implements IDaoBase<Carrinho> {

    Connection conexao = null;

    @Override
    public int inserir(Carrinho obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO Carrinho "
                + "(ID, CLIENTE_ID, VL_TOTAL"
                + " ) VALUES ("
                + "?, ?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, obj.getId());
            statement.setInt(2, obj.getClienteId());
            statement.setDouble(3, obj.getValorTotal());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return idGerado;
    }

    @Override
    public void atualizar(Carrinho obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carrinho> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Carrinho> listar(int idCliente) throws SQLException, Exception {
        ArrayList<Carrinho> compras = new ArrayList<>();

        String query = "SELECT * FROM Carrinho WHERE CLIENTE_ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet result = statement.executeQuery();
            Carrinho c = null;
            while (result.next()) {
                c = new Carrinho(
                        result.getInt("ID"),
                        result.getDouble("VL_TOTAL"),
                        result.getDate("DT_TRANSACAO")
                );
                compras.add(c);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return compras;
    }

    @Override
    public Carrinho getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
