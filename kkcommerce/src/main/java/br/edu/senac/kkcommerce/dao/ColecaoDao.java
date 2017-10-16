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
public class ColecaoDao implements IDaoBase<Colecao> {

    Connection conexao = null;
    
    @Override
    public ArrayList<Colecao> listar() throws SQLException, Exception {
        ArrayList<Colecao> colecoes = new ArrayList<>();
        String query = "SELECT ID, NOME FROM Colecao";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao =  ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);

            result = statement.executeQuery();

            while (result.next()) {
                colecoes.add(new Colecao(
                        result.getInt("ID"),
                        result.getString("NOME"))
                );
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
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

    @Override
    public Colecao getById(int id) throws SQLException, Exception {
        Colecao colecao = null;
        String query = "SELECT NOME FROM Colecao WHERE ID = ?";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while (result.next()) {
                colecao = new Colecao(id, result.getString("NOME"));
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
        return colecao;
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int inserir(Colecao obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Colecao obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
