package ch.lab4tech.jav09.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * source: http://javateacher.co.in/core-java/jdbc/jdbc-dao-example-2/
 */
public class ConnectionFactory {

    String driverClassName = "org.hsqldb.jdbcDriver";
    String url = "jdbc:hsqldb:file:database";
    String user = "sa";
    String password = "";
    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }
}