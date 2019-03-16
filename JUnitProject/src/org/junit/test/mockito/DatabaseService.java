package org.junit.test.mockito;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {
	private static Connection con;

	public DatabaseService() throws ClassNotFoundException, SQLException {
		if (con.isClosed()) {

			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SYSTEM", "SYSTEM");
		}
	}

	public int runQuery(String sql) throws ClassNotFoundException, SQLException {
		return con.createStatement().executeUpdate(sql);
	}
}