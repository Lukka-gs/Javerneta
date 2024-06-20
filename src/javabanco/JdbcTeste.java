package javabanco;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class JdbcTeste {
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/test","root",""); 
		//String de conexão - "jdbc:mysql://ip/estancia_do_banco", "usuario", "senha"); Se pedir porta é 3306
		System.out.println("Conectado ao Banco de Dados local!");
		con.close();
	}

}
