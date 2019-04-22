package ch.lab4tech.jav09.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory = null;
    String driverClassName = "org.hsqldb.jdbcDriver";
    String url = "jdbc:hsqldb:file:database";
    String user = "sa";
    String password = "";

    private ConnectionFactory() {
        try {
            Class.forName(driverClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() throws SQLException {
        Connection conn;
        conn = DriverManager.getConnection(url, user, password);
        return conn;
    }
}