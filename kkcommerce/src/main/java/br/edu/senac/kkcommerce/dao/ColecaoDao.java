package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Colecao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class ColecaoDao {

    Connection conexao = null;

    public void inserir(Colecao c) throws SQLException, Exception {
        String query = "INSERT INTO Colecao (Nome, Periodo, Ano, Ativo, DataCadastro)"
                + " VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, c.getNome());
            statement.setString(2, c.getPeriodo());
            statement.setInt(3, c.getAno());
            statement.setBoolean(4, c.isAtivo());
            statement.setDate(5, new java.sql.Date(c.getDataCriacao().getTime()));

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

    public void atualizar(Colecao c) throws SQLException, Exception {
        String query = "UPDATE Colecao SET Nome = ?, Periodo = ?, Ano = ? WHERE Id = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, c.getNome());
            statement.setString(2, c.getPeriodo());
            statement.setInt(3, c.getAno());
            statement.setInt(4, c.getId());

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

    public void excluir(int id) throws SQLException, Exception {
        String query = "UPDATE Colecao SET Ativo = false WHERE Id = ?";
        PreparedStatement statement = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);

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

    public ArrayList<Colecao> listar() throws SQLException {
        ArrayList<Colecao> colecoes = new ArrayList<>();
        String query = "SELECT * FROM Colecao";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);

            result = statement.executeQuery();

            while (result.next()) {
                colecoes.add(new Colecao(
                        result.getInt("Id"),
                        result.getString("Nome"),
                        result.getString("Periodo"), 
                        result.getInt("Ano"), 
                        result.getBoolean("Ativo"), 
                        new java.util.Date(result.getDate("DataCadastro").getTime()))
                );
            }
        } finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }

            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return colecoes;
    }
}
