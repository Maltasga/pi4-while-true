package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.model.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class ProdutoDao implements IDaoBase<Produto> {

    Connection conexao = null;

    @Override
    public void inserir(Produto obj) throws SQLException, Exception {
        String query = "INSERT INTO Produto "
                + "(Codigo, Nome, Descricao, IdColecao, Tipo, Cor, ValorProducao, ValorVenda, Ativo, DataCadastro) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(2, obj.getNome());
            statement.setString(3, obj.getDescricao());
            statement.setInt(4, obj.getIdColecao());
            statement.setString(5, obj.getTipo());
            statement.setString(6, obj.getCor());
            statement.setDouble(7, obj.getValor());
            statement.setBoolean(9, obj.isAtivo());
            statement.setDate(10, Util.toSQLDate(obj.getDataCadastro()));

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
    public void atualizar(Produto obj) throws SQLException, Exception {
        String query = "UPDATE Produto SET Nome = ?, Descricao = ?, ValorProducao = ?, ValorVenda = ? "
                + "WHERE Id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, obj.getNome());
            statement.setString(2, obj.getDescricao());
            statement.setDouble(3, obj.getValor());
            statement.setInt(4, obj.getId());
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
        String query = "UPDATE Produto SET Ativo = FALSE WHERE Id = ?";
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
    
    @Override
    public ArrayList<Produto> listar() throws SQLException {
        ArrayList<Produto> produtos = new ArrayList<>();

        String query = "SELECT "
                + "obj.Id, "
                + "obj.Codigo, "
                + "obj.Nome, "
                + "obj.Descricao, "
                + "obj.IdColecao, "
                + "c.Nome AS NomeColecao, "
                + "obj.Tipo, obj.Cor, "
                + "obj.ValorProducao, "
                + "obj.ValorVenda, obj.Ativo, "
                + "obj.DataCadastro "
                + "FROM Produto p "
                + "JOIN Colecao c ON obj.IdColecao = c.ID";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Produto p = null;
            while (result.next()) {
                p = new Produto(
                        result.getInt("Id"),
                        result.getString("Nome"),
                        result.getString("Descricao"),
                        result.getInt("IdColecao"),
                        result.getString("Tipo"),
                        result.getString("Cor"),
                        result.getDouble("Valor"),
                        result.getBoolean("Ativo"),
                        Util.toUtilDate(result.getDate("DataCadastro")));
                produtos.add(p);

            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return produtos;
    }

    @Override
    public Produto getById(int id)  throws SQLException, Exception{
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
