package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Perfil;
import br.edu.senac.kkcommerce.model.Usuario;
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
public class UsuarioDao implements IDaoBase<Usuario> {

    Connection conexao = null;

    @Override
    public int inserir(Usuario obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO Usuario (NOME, EMAIL, LOGIN, SENHA, ID_PERFIL) "
                + "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, obj.getNome());
            statement.setString(2, obj.getEmail());
            statement.setString(3, obj.getLogin());
            statement.setString(4, obj.getSenha());
            statement.setInt(5, obj.getIdPerfil());
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
    public void atualizar(Usuario obj) throws SQLException, Exception {
        String query = "UPDATE Usuario SET Nome = ?, Email = ? WHERE Id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, obj.getNome());
            statement.setString(2, obj.getEmail());
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
        String query = "UPDATE Usuario SET Ativo = FALSE WHERE Id = ?";
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
    public List<Usuario> listar() throws SQLException, Exception {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        String query = "SELECT * FROM SELECT_USUARIO_COMPLETO";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            Usuario u = null;
            while (result.next()) {
                u = new Usuario(
                        result.getInt("ID"),
                        result.getInt("ID_PERFIL"),
                        result.getString("NOME"),
                        result.getString("EMAIL"),
                        result.getString("LOGIN"),
                        result.getString("SENHA"),
                        result.getBoolean("Ativo"),
                        Util.toUtilDate(result.getDate("DT_CADASTRO")));

                u.setPerfil(new Perfil(result.getInt("ID_PERFIL"), result.getString("NM_PERFIL")));

                usuarios.add(u);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return usuarios;
    }

    @Override
    public Usuario getById(int id) throws SQLException, Exception {
        Usuario usuario = null;

        String query = "SELECT * FROM SELECT_USUARIO_COMPLETO WHERE ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                usuario = new Usuario(
                        result.getInt("ID"),
                        result.getInt("ID_PERFIL"),
                        result.getString("NOME"),
                        result.getString("EMAIL"),
                        result.getString("LOGIN"),
                        result.getString("SENHA"),
                        result.getBoolean("Ativo"),
                        Util.toUtilDate(result.getDate("DT_CADASTRO")));

                usuario.setPerfil(new Perfil(result.getInt("ID_PERFIL"), result.getString("NM_PERFIL")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return usuario;
    }
}
