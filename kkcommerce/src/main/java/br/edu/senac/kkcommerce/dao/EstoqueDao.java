package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Estoque;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query = "INSERT INTO ESTOQUE (IdProduto, Tamanho, Quantidade) "
                + "VALUES (?, ?, ?);  SELECT LAST_INSERT_ID() as 'ultimo_id';";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, e.getIdProduto());
            statement.setString(2, e.getTamanho());
            statement.setInt(3, e.getQuantidade());
            ResultSet rs = statement.executeQuery();
            
            idGerado = rs.getInt("ultimo_id");
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
                + "WHERE IdProduto = ?\n"
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
                + "WHERE IdProduto = ?"
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
                + "IdProduto, "
                + "Tamanho, "
                + "Quantidade "
                + "FROM ESTOQUE "
                + "WHERE IdProduto = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idProduto);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                lista.add(new Estoque(
                        result.getInt("Id"),
                        result.getInt("IdProduto"),
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
