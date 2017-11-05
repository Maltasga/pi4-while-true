package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author While True
 */
public class EstoqueDao implements IDaoBase<Estoque> {

    Connection conexao = null;

    @Override
    public int inserir(Estoque e) throws SQLException {
        int idGerado = 0;
        String query = "INSERT INTO ESTOQUE (Id_Produto, Tamanho, Quantidade) "
                + "VALUES (?, ?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, e.getIdProduto());
            statement.setString(2, e.getTamanho());
            statement.setInt(3, e.getQuantidade());
            statement.execute();

            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                idGerado = rs.getInt(1);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return idGerado;
    }

    @Override
    public void atualizar(Estoque e) throws SQLException {
        String query = "UPDATE Estoque SET Quantidade = ? "
                + "WHERE Id_Produto = ?"
                + "AND Tamanho = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, e.getQuantidade());
            statement.setInt(2, e.getIdProduto());
            statement.setString(3, e.getTamanho());

            statement.execute();
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    @Override
    public List<Estoque> listar() throws SQLException, Exception {
        ArrayList<Estoque> listaEstoque = new ArrayList<>();

        String query = "SELECT "
                + "ID, "
                + "ID_PRODUTO, "
                + "TAMANHO, "
                + "QUANTIDADE "
                + "FROM Estoque";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Estoque e = null;
            while (result.next()) {
                e = new Estoque(
                        result.getInt("ID"),
                        result.getInt("ID_PRODUTO"),
                        result.getString("TAMANHO"),
                        result.getInt("QUANTIDADE"));
                listaEstoque.add(e);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return listaEstoque;
    }
    
    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estoque getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
