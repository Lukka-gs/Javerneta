package controller.dao.contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javabanco.ConnectionFactory;
import model.contato.Contato;

public class ContatoDao {
	private Connection con;
	
	public ContatoDao() throws SQLException { //Se coloca um throws porque esse cara é alguém que vai ser usado futuramente, ele é uma classe de base
		this.con = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql = "insert into contatos (nome, email, endereco) values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco()); //Até aqui ele só pega e armazena na memória, ainda não envio para o banco
		
		stmt.execute(); //Só aqui que ele joga no banco
		
		stmt.close();
		con.close();
	}
	
	public List<Contato> getLista() throws SQLException{
		String query = "select * from contatos";
		PreparedStatement stmt = con.prepareStatement(query);
		ResultSet rset = stmt.executeQuery();
		List<Contato> contatos = new ArrayList<Contato>();
		
		while (rset.next()) {
			Contato contato = new Contato();
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
			contatos.add(contato);
		}
		
		rset.close();
		stmt.close();
		con.close();
		
		return contatos;
	}

}
