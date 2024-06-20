package javabanco;


import java.sql.Connection;
import java.sql.SQLException;

public class TestaFabricaConexoes {
	static Connection con;
	
	public static void main(String[] args) {
		try {
			con = ConnectionFactory.getConnection(); // se você coloca connection con aqui, ele está criando uma variável local, quando na verdade queremos usar o con global que foi declarado anteriormente
			System.out.println("Conectado ao Banco de Dados Local");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
