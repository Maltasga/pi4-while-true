/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.ImagemProduto;
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
public class ImagemDao implements IDaoBase<ImagemProduto> {

    Connection conexao = null;

    @Override
    public int inserir(ImagemProduto obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO ProdutoImagem "
                + "(ID_PRODUTO, Nome) "
                + "VALUES (?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setInt(1, obj.getProdutoId());
            statement.setString(2, obj.getNome());
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
    public List<ImagemProduto> listar() throws SQLException {
        ArrayList<ImagemProduto> imagens = new ArrayList<>();

        String query = "SELECT * FROM ProdutoImagem";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            ImagemProduto i = null;
            while (result.next()) {
                i = new ImagemProduto(
                        result.getInt("ID"),
                        result.getInt("ID_PRODUTO"),
                        result.getString("Nome"),
                        "imagem_" + result.getInt("ID") + "_" + result.getInt("ID_PRODUTO"));
                imagens.add(i);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return imagens;
    }

    @Override
    public ImagemProduto getById(int id) throws SQLException, Exception {
        ImagemProduto imagem = null;

        String query = "SELECT * FROM ProdutoImagem WHERE ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                imagem = new ImagemProduto(
                        result.getInt("ID"),
                        result.getInt("ID_PRODUTO"),
                        result.getString("Nome"),
                        "imagem_" + result.getInt("ID") + "_" + result.getInt("ID_PRODUTO"));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return imagem;
    }

    @Override
    public void atualizar(ImagemProduto obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
