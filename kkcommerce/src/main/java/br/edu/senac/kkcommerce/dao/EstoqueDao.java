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

    public void atualizar(Estoque e, int quantidade) throws SQLException {
        String query = "UPDATE Estoque SET Quantidade = (Quantidade + ?)\n"
                + "WHERE Id_Produto = ?\n"
                + "AND Tamanho = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, quantidade);
            statement.setInt(2, e.getId());
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

    public ArrayList<Estoque> listarPorProduto(int idProduto) throws SQLException {
        ArrayList<Estoque> lista = new ArrayList<>();
        String query = "SELECT "
                + "Id, "
                + "Id_Produto, "
                + "Tamanho, "
                + "Quantidade "
                + "FROM ESTOQUE "
                + "WHERE Id_Produto = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idProduto);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                lista.add(new Estoque(
                        result.getInt("Id"),
                        result.getInt("Id_Produto"),
                        result.getString("Tamanho"),
                        result.getInt("Quantidade")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        }
        return lista;
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estoque> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estoque getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
