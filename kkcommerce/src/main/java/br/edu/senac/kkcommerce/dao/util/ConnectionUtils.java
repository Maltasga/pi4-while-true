package br.edu.senac.kkcommerce.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author While True
 */
public class ConnectionUtils {

    public static Connection getConnection() {

        Connection connection = null;
        try {
            String URL = DbConstants.URL;
            Properties prop = new Properties();
            prop.put("user", DbConstants.USER);
            prop.put("password", DbConstants.PASSWORD);
            connection = DriverManager.getConnection(URL, prop);

        } catch (SQLException ex) {
            try {
                throw new Exception(ex.getMessage());
            } catch (Exception ex1) {
                Logger.getLogger(ConnectionUtils.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return connection;
    }
}
