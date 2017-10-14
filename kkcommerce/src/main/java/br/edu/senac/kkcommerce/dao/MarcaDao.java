package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Marca;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author while true
 */
public class MarcaDao implements IDaoBase<Marca> {

    Connection conexao = null;

    @Override
    public ArrayList<Marca> listar() throws SQLException {
        ArrayList<Marca> marcas = new ArrayList<>();
        String query = "SELECT ID, NOME FROM Marca";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);

            result = statement.executeQuery();

            while (result.next()) {
                marcas.add(new Marca(
                        result.getInt("ID"),
                        result.getString("NOME"))
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
        return marcas;
    }

    @Override
    public Marca getById(int id) throws SQLException, Exception {
        Marca marca = null;
        String query = "SELECT NOME FROM Marca WHERE ID = ?";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while (result.next()) {
                marca = new Marca(id, result.getString("NOME"));
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
        return marca;
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inserir(Marca obj) throws SQLException, Exception {
        String query = "INSERT INTO Marca "
                + "(NOME) VALUES "
                + "(?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, obj.getNome());

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
    public void atualizar(Marca obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
