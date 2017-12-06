/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.Relatorio;
import br.edu.senac.kkcommerce.model.Util;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Karolina
 */
public class RelatorioDao implements IDaoBase<Relatorio> {

    Connection conexao = null;

    public ArrayList<Relatorio> listarTudo(Date dataMin, Date dataMax) throws SQLException {

        ArrayList<Relatorio> relatorio = new ArrayList<>();

        String query = "SELECT \n"
                + "C.PROTOCOLO,\n"
                + "SUM(CI.quantidade) AS QUANTPROD,\n"
                + "C.VL_TOTAL,\n"
                + "C.DT_TRANSACAO\n"
                + "FROM CARRINHO AS C\n"
                + "INNER JOIN CARRINHOITEM AS CI\n"
                + "ON CI.CARRINHO_ID = C.ID\n"
                + "WHERE DT_TRANSACAO BETWEEN ? AND ?"
                + "GROUP BY C.PROTOCOLO, C.VL_TOTAL, C.DT_TRANSACAO";

        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setDate(1, Util.toSQLDate(dataMin));
            statement.setDate(2, Util.toSQLDate(dataMax));
            ResultSet result = statement.executeQuery();
            Relatorio r = null;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("C.PROTOCOLO"),
                        result.getInt("QUANTPROD"),
                        0,
                        result.getDouble("C.VL_TOTAL"),
                        Util.toUtilDate(result.getDate("C.DT_TRANSACAO")));
                relatorio.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return relatorio;
    }

    public ArrayList<Relatorio> listarTudoGenero(Date dataMin, Date dataMax, String genero) throws SQLException {

        ArrayList<Relatorio> relatorio = new ArrayList<>();

        String query = "SELECT \n"
                + "C.PROTOCOLO,\n"
                + "COUNT(CI.*) AS QUANTPROD,\n"
                + "C.FRETE,\n"
                + "C.VL_TOTAL,\n"
                + "C.DT_TRANSACAO\n"
                + "FROM CARRINHO AS C\n"
                + "INNER JOIN CARRINHOITEM AS CI\n"
                + "ON CI.CARIINHO_ID = C.ID\n"
                + "INNER JOIN PRODUTO AS P\n"
                + "ON P.ID = CI.PRODUTO_ID\n"
                + "INNER JOIN CATEGORIA AS CT\n"
                + "ON CT.ID = P.CATEGORIA_ID AND CT.GENERO = ?\n"
                + "WHERE DT_TRANSACAO BETWEEN ? AND ?";

        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, genero);
            statement.setDate(2, Util.toSQLDate(dataMin));
            statement.setDate(2, Util.toSQLDate(dataMax));
            ResultSet result = statement.executeQuery();
            Relatorio r = null;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("C.PROTOCOLO"),
                        result.getInt("QUANTPROD"),
                        result.getDouble("C.FRETE"),
                        result.getDouble("C.VL_TOTAL"),
                        Util.toUtilDate(result.getDate("C.DT_TRANSACAO")));
                relatorio.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return relatorio;
    }

    public ArrayList<Relatorio> listarCat(Date dataMin, Date dataMax, int idCat) throws SQLException {

        ArrayList<Relatorio> relatorio = new ArrayList<>();

        String query = "SELECT \n"
                + "C.PROTOCOLO,\n"
                + "COUNT(CI.*) AS QUANTPROD,\n"
                + "C.FRETE,\n"
                + "C.VL_TOTAL,\n"
                + "C.DT_TRANSACAO\n"
                + "FROM CARRINHO AS C\n"
                + "INNER JOIN CARRINHOITEM AS CI\n"
                + "ON CI.CARRINHO_ID = C.ID\n"
                + "INNER JOIN PRODUTO AS P\n"
                + "ON P.ID = CI.PRODUTO_ID AND ID_CATEGORIA = ?\n"
                + "WHERE DT_TRANSACAO BETWEEN ? AND ?";

        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, idCat);
            statement.setDate(2, Util.toSQLDate(dataMin));
            statement.setDate(2, Util.toSQLDate(dataMax));
            ResultSet result = statement.executeQuery();
            Relatorio r = null;
            while (result.next()) {
                r = new Relatorio(
                        result.getString("C.PROTOCOLO"),
                        result.getInt("QUANTPROD"),
                        result.getDouble("C.FRETE"),
                        result.getDouble("C.VL_TOTAL"),
                        Util.toUtilDate(result.getDate("C.DT_TRANSACAO")));
                relatorio.add(r);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return relatorio;
    }

    @Override
    public int inserir(Relatorio obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Relatorio obj) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Relatorio> listar() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Relatorio getById(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
