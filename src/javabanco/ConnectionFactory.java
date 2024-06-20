package javabanco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	public static Connection getConnection() throws SQLException { //Uma única instancia da conexão para a aplicação. Por isso o static
		return DriverManager.getConnection("jdbc:mysql://localhost/test","root","");
	}
}
