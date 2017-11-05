
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Perfil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author while true
 */
public class PerfilDao implements IDaoBase<Perfil>{

    Connection conexao = null;
    @Override
    public int inserir(Perfil obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Perfil obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Perfil> listar() throws SQLException, Exception {
        ArrayList<Perfil> colecoes = new ArrayList<>();
        String query = "SELECT ID, NOME FROM Perfil";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao =  ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);

            result = statement.executeQuery();

            while (result.next()) {
                colecoes.add(new Perfil(
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
    public Perfil getById(int id) throws SQLException, Exception {
        Perfil perfil = null;
        String query = "SELECT NOME FROM Perfil WHERE ID = ?";

        PreparedStatement statement = null;
        ResultSet result = null;
        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeQuery();

            while (result.next()) {
                perfil = new Perfil(id, result.getString("NOME"));
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
        return perfil;
    }
    
}
