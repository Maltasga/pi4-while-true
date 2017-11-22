package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.StatusCarrinhoDetalhe;
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
 * @author gabri
 */
public class StatusCarrinhoDetalheDAO implements IDaoBase<StatusCarrinhoDetalhe> {

    Connection conexao = null;

    @Override
    public int inserir(StatusCarrinhoDetalhe obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO StatusCarrinhoDetalhe "
                + "(STATUS_ID, CARRINHO_ID) "
                + "VALUES (?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getStatus_id());
            statement.setInt(2, obj.getCarrinho_id());
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
    public void atualizar(StatusCarrinhoDetalhe obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<StatusCarrinhoDetalhe> listar() throws SQLException, Exception {
        ArrayList<StatusCarrinhoDetalhe> status = new ArrayList<>();

        String query = "SELECT * FROM SELECT_STATUS_CARRINHO_COMPLETO";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            StatusCarrinhoDetalhe s = null;
            while (result.next()) {
                s = new StatusCarrinhoDetalhe(
                        result.getInt("ID"),
                        result.getInt("STATUS_ID"),
                        result.getInt("CARRINHO_ID"),
                        Util.toUtilDate(result.getDate("DT_CADASTRO")),
                        result.getString("STATUS"),
                        result.getString("NOME"));
                status.add(s);

            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return status;
    }

    @Override
    public StatusCarrinhoDetalhe getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
