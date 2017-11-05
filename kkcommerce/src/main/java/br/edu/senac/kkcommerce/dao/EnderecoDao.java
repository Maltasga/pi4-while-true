/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Endereco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Karolina G. K.
 */
public class EnderecoDao implements IDaoBase<Endereco> {

    Connection conexao = null;

    @Override
    public int inserir(Endereco obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO Endereco "
                + "(ID, CLIENTE_ID, LOGRADOURO, NUMERO, COMPLEMENTO, CIDADE, UF,"
                + " CEP, PRINCIPAL) VALUES ("
                + "?, ?, ?, ?, ?, ?, ?, ?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getId());
            statement.setInt(2, obj.getClienteId());
            statement.setString(3, obj.getLogradouro());
            statement.setString(4, obj.getNumero());
            statement.setString(5, obj.getComplemento());
            statement.setString(6, obj.getCidade());
            statement.setString(7, obj.getUf());
            statement.setString(8, obj.getCep());
            statement.setBoolean(9, obj.isPrincipal());
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
    public void atualizar(Endereco obj) throws SQLException, Exception {
        String query = "UPDATE Endereco"
                + "SET LOGRADOURO = ?, NUMERO = ?, COMPLEMENTO = ?, CIDADE = ?, UF = ?,"
                + " CEP = ?, PRINCIPAL = ? "
                + "WHERE ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, obj.getLogradouro());
            statement.setString(2, obj.getNumero());
            statement.setString(3, obj.getComplemento());
            statement.setString(4, obj.getCidade());
            statement.setString(5, obj.getUf());
            statement.setString(6, obj.getCep());
            statement.setBoolean(7, obj.isPrincipal());
            statement.setInt(8, obj.getId());

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
        String query = "UPDATE Endereco"
                + "SET ATIVO = ? "
                + "WHERE ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setBoolean(1, false);
            statement.setInt(2, id);

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
    public List<Endereco> listar() throws SQLException, Exception {
        return null;
    }

    @Override
    public Endereco getById(int id) throws SQLException, Exception {
        return null;
    }

}
