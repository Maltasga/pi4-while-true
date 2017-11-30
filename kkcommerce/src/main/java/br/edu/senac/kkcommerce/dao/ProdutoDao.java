package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Colecao;
import br.edu.senac.kkcommerce.model.Marca;
import br.edu.senac.kkcommerce.model.Produto;
import br.edu.senac.kkcommerce.model.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class ProdutoDao implements IDaoBase<Produto> {

    Connection conexao = null;

    @Override
    public int inserir(Produto obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO Produto "
                + "(NOME, DESCRICAO, ID_MARCA, ID_COLECAO, Valor) "
                + "VALUES (?, ?, ?, ?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, obj.getNome());
            statement.setString(2, obj.getDescricao());
            statement.setInt(3, obj.getIdMarca());
            statement.setInt(4, obj.getIdColecao());
            statement.setDouble(5, obj.getValor());
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
    public void atualizar(Produto obj) throws SQLException, Exception {
        String query = "UPDATE Produto SET Nome = ?, Descricao = ?, valor = ? "
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

        String query = "SELECT * FROM SELECT_PRODUTO_COMPLETO";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Produto p = null;
            while (result.next()) {
                p = new Produto(
                        result.getInt("ID"),
                        result.getString("NOME"),
                        result.getString("DESCRICAO"),
                        result.getInt("ID_COLECAO"),
                        result.getInt("ID_MARCA"),
                        result.getDouble("VALOR"),
                        result.getBoolean("ATIVO"),
                        Util.toUtilDate(result.getDate("DT_CADASTRO")));
                p.setPercDesconto(result.getDouble("PERC_DESCONTO"));
                p.setMarca(new Marca(result.getInt("ID_MARCA"), result.getString("NM_MARCA")));
                p.setColecao(new Colecao(result.getInt("ID_COLECAO"), result.getString("NM_COLECAO")));
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
    public Produto getById(int id) throws SQLException, Exception {
        Produto produto = null;

        String query = "SELECT * FROM SELECT_PRODUTO_COMPLETO WHERE ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                produto = new Produto(
                        result.getInt("ID"),
                        result.getString("NOME"),
                        result.getString("DESCRICAO"),
                        result.getInt("ID_COLECAO"),
                        result.getInt("ID_MARCA"),
                        result.getDouble("VALOR"),
                        result.getBoolean("ATIVO"),
                        Util.toUtilDate(result.getDate("DT_CADASTRO")));

                produto.setPercDesconto(result.getDouble("PERC_DESCONTO"));
                produto.setMarca(new Marca(result.getInt("ID_MARCA"), result.getString("NM_MARCA")));
                produto.setColecao(new Colecao(result.getInt("ID_Colecao"), result.getString("NM_COLECAO")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return produto;
    }
}
