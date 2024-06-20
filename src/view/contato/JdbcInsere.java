package view.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javabanco.ConnectionFactory;

public class JdbcInsere {
	public static void main(String[] args) {
		try {
			String sql = "insert into contatos (nome, email, endereco) values (?,?,?)"; //O ? indica que você está pegando a informação em tempo de execução. Seria um placeholder
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, "Victor");
			stmt.setString(2, "Victor@gmail.com");
			stmt.setString(3, "Av. Brasil, 2000");
			
			stmt.execute();
			
			stmt.close();
			con.close();
			
			System.out.println("Gravacao feita com sucesso!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
