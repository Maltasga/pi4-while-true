package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Promocao;
import br.edu.senac.kkcommerce.model.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while true
 */
public class PromocaoDao implements IDaoBase<Promocao> {

    Connection conexao = null;

    @Override
    public int inserir(Promocao obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO promocao "
                + "(PRODUTO_ID, DT_INICIO, DT_FIM, PERC_DESCONTO) "
                + "VALUES (?, ?, ?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getProdutoId());
            statement.setDate(2, Util.toSQLDate(obj.getDataInicio()));
            statement.setDate(3, Util.toSQLDate(obj.getDataFim()));
            statement.setDouble(4, obj.getPercDesconto());
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
    public void atualizar(Promocao obj) throws SQLException, Exception {
        String query = "UPDATE promocao "
                + "SET DT_FIM = ?, "
                + "PERC_DESCONTO = ? "
                + "WHERE ID = ?;";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setDate(1, Util.toSQLDate(obj.getDataFim()));
            statement.setDouble(2, obj.getPercDesconto());
            statement.setInt(3, obj.getPromocaoId());
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
        String query = "UPDATE promocao "
                + "SET DT_FIM = DATE_ADD(NOW(), INTERVAL -1 DAY) "
                + "WHERE ID = ?";
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
    public List<Promocao> listar() throws SQLException, Exception {
        ArrayList<Promocao> promocoes = new ArrayList<>();

        String query = "SELECT * FROM select_promocao_produto";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                promocoes.add(new Promocao(
                        result.getInt("PRODUTO_ID"),
                        result.getString("PRODUTO_NOME"),
                        result.getInt("PROMO_ID"),
                        Util.toUtilDate(result.getDate("DT_INICIO")),
                        Util.toUtilDate(result.getDate("DT_FIM")),
                        result.getDouble("PERC_DESCONTO")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return promocoes;
    }

    @Override
    public Promocao getById(int id) throws SQLException, Exception {

        Promocao promocao = null;

        String query = "SELECT * FROM select_promocao_produto WHERE PROMO_ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                promocao = new Promocao(
                        result.getInt("PRODUTO_ID"),
                        result.getString("PRODUTO_NOME"),
                        result.getInt("PROMO_ID"),
                        Util.toUtilDate(result.getDate("DT_INICIO")),
                        Util.toUtilDate(result.getDate("DT_FIM")),
                        result.getDouble("PERC_DESCONTO"));

            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return promocao;
    }
}
