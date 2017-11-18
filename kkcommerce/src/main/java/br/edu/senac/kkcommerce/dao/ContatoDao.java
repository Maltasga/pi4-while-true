/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while_true
 */
public class ContatoDao implements IDaoBase<Contato> {

    Connection conexao = null;

    @Override
    public int inserir(Contato obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO Contato "
                + "(ID, CLIENTE_ID, TIPO_ERRO, DESCRICAO, PROTOCOLO"
                + " ) VALUES ("
                + "?, ?, ?, ?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, obj.getId());
            statement.setInt(2, obj.getClienteId());
            statement.setString(3, obj.getTipo_erro());
            statement.setString(4, obj.getDescricao());
            statement.setLong(5, obj.getProtocolo());
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
    public void atualizar(Contato obj) throws SQLException, Exception {
        String query = "UPDATE Contato SET Protocolo = ? WHERE Id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setLong(1, obj.getProtocolo());
            statement.setLong(2, obj.getId());
            statement.execute();
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Contato> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Contato> listar(int idCliente) throws SQLException, Exception {
        ArrayList<Contato> contatos = new ArrayList<>();

        String query = "SELECT * FROM Contato WHERE CLIENTE_ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idCliente);
            ResultSet result = statement.executeQuery();
            Contato c = null;
            while (result.next()) {
                c = new Contato(
                        result.getLong("PROTOCOLO"),
                        result.getString("TIPO_ERRO"),
                        result.getString("DESCRICAO"),
                        result.getDate("DT_TRANSACAO"),
                        result.getString("STATUS")
                );
                contatos.add(c);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return contatos;
    }

    @Override
    public Contato getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
