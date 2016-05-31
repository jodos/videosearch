package ch.lab4tech.jav09.db;

import java.sql.Connection;
import java.sql.SQLException;

public class CommonJdbcConnection {
	protected Connection connection = null;

	protected Connection getConnection() throws SQLException {
		Connection connection;
		connection = ConnectionFactory.getInstance().getConnection();
		return connection;
	}
}
