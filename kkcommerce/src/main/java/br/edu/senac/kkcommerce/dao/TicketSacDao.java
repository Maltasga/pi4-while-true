/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.senac.kkcommerce.dao;

import br.edu.senac.kkcommerce.dao.util.ConnectionUtils;
import br.edu.senac.kkcommerce.model.TicketSac;
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
 * @author while_true
 */
public class TicketSacDao implements IDaoBase<TicketSac> {

    Connection conexao = null;

    @Override
    public int inserir(TicketSac obj) throws SQLException, Exception {
        int idGerado = 0;
        String query = "INSERT INTO TICKETSAC "
                + "(ID, CLIENTE_ID, TIPO_ERRO, DESCRICAO, PROTOCOLO"
                + " ) VALUES ("
                + "?, ?, ?, ?, ?);";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            statement.setLong(1, obj.getId());
            statement.setInt(2, obj.getClienteId());
            statement.setString(3, obj.getTipo_erro());
            statement.setString(4, obj.getDescricao());
            statement.setLong(5, obj.getProtocolo());
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
    public void atualizar(TicketSac obj) throws SQLException, Exception {
        String query = "UPDATE TicketSac "
                + "SET DESCRICAO = ? "
                + "WHERE ID = ?";

        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, obj.getDescricao());
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
    public List<TicketSac> listar() throws SQLException, Exception {
        ArrayList<TicketSac> ticketSacs = new ArrayList<>();
        String query = "SELECT "
                + "ID, "
                + "ID_CLIENTE, "
                + "DT_TRANSACAO, "
                + "PROTOCOLO, "
                + "DESCRICAO, "
                + "TIPO_ERRO, "
                + "STATUS "
                + "FROM TicketSac "
                + "WHERE STATUS = 'PENDENTE'";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            TicketSac ts = null;
            while (result.next()) {
                ts = new TicketSac(
                        result.getInt("ID"),
                        result.getInt("ID_CLIENTE"),
                        Util.toUtilDate(result.getDate("DT_TRANSACAO")),
                        result.getString("TIPO_ERRO"),
                        result.getString("DESCRICAO"),
                        result.getInt("PROTOCOLO"),
                        result.getString("STATUS"));
                ticketSacs.add(ts);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return ticketSacs;
    }

    @Override
    public TicketSac getById(int id) throws SQLException, Exception {
        TicketSac ticketSac = null;
        String query = "SELECT "
                + "ID, "
                + "ID_CLIENTE, "
                + "DT_TRANSACAO, "
                + "PROTOCOLO, "
                + "DESCRICAO, "
                + "TIPO_ERRO, "
                + "STATUS "
                + "FROM TicketSac "
                + "WHERE ID = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                ticketSac = new TicketSac(
                        result.getInt("ID"),
                        result.getInt("ID_CLIENTE"),
                        Util.toUtilDate(result.getDate("DT_TRANSACAO")),
                        result.getString("TIPO_ERRO"),
                        result.getString("DESCRICAO"),
                        result.getInt("PROTOCOLO"),
                        result.getString("STATUS"));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }
            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
        return ticketSac;
    }

    @Override
    public void excluir(int id) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
