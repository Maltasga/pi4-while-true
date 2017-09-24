package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author While True
 */
public class EstoqueDao {

    Connection conexao = null;

    public void inserir(ArrayList<Estoque> lista) throws SQLException {
        for (Estoque e : lista) {
            inserir(e);
        }
    }

    public void inserir(Estoque e) throws SQLException {
        String query = "INSERT INTO ESTOQUE (IdProduto, IdFilial, Tamanho, Quantidade) "
                + "VALUES (?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, e.getIdProduto());
            statement.setInt(2, e.getIdFilial());
            statement.setString(3, e.getTamanho());
            statement.setInt(4, e.getQuantidade());
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

    public void atualizar(Estoque e, int quantidade) throws SQLException {
        String query = "UPDATE Estoque SET Quantidade = (Quantidade + ?)\n"
                + "WHERE IdProduto = ?\n"
                + "AND IdFilial = ?\n"
                + "AND Tamanho = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, quantidade);
            statement.setInt(2, e.getId());
            statement.setInt(3, e.getIdFilial());
            statement.setString(4, e.getTamanho());
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
                + "WHERE IdProduto = ?"
                + " AND IdFilial = ? "
                + "AND Tamanho = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, e.getQuantidade());
            statement.setInt(2, e.getIdProduto());
            statement.setInt(3, e.getIdFilial());
            statement.setString(4, e.getTamanho());

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

    public ArrayList<Estoque> listarPorFilial(int idFilial) throws SQLException {
        ArrayList<Estoque> lista = new ArrayList<>();
        String query = "SELECT "
                + "Id, "
                + "IdProduto, "
                + "IdFilial, "
                + "Tamanho, "
                + "Quantidade "
                + "FROM ESTOQUE "
                + "WHERE IdFilial = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idFilial);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                lista.add(new Estoque(
                        result.getInt("Id"),
                        result.getInt("IdProduto"),
                        result.getInt("IdFilial"),
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

    public ArrayList<Estoque> listarPorProduto(int idProduto, int idFilial) throws SQLException {
        ArrayList<Estoque> lista = new ArrayList<>();
        String query = "SELECT "
                + "Id, "
                + "IdProduto, "
                + "IdFilial, "
                + "Tamanho, "
                + "Quantidade "
                + "FROM ESTOQUE "
                + "WHERE IdProduto = ? "
                + "AND IdFilial = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idProduto);
            statement.setInt(2, idFilial);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                lista.add(new Estoque(
                        result.getInt("Id"),
                        result.getInt("IdProduto"),
                        result.getInt("IdFilial"),
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

}
