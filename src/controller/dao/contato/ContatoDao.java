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
	
	public ContatoDao() throws SQLException { 
		this.con = ConnectionFactory.getConnection();
	}
	
	public void adiciona(Contato contato) throws SQLException {
		String sql = "insert into contatos (nome, email, endereco) values (?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, contato.getNome());
		stmt.setString(2, contato.getEmail());
		stmt.setString(3, contato.getEndereco()); 
		
		stmt.execute(); 
		
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

	public List<Contato> getListaPorLetra(String letra) throws SQLException{
		String query = "select * from contatos where nome like ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, letra + "%");

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

	public Contato getContatoPorId(String Id) throws SQLException{
		String query = "select * from contatos where id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, Id);

		ResultSet rset = stmt.executeQuery();
		Contato contato = null;

		if (rset.next()) {
			contato = new Contato();
			contato.setNome(rset.getString("nome"));
			contato.setEmail(rset.getString("email"));
			contato.setEndereco(rset.getString("endereco"));
		}

		rset.close();
		stmt.close();
		con.close();

		return contato;
	}
	
	public void deletaPorId(String Id) throws SQLException{
		String query = "delete from contatos where id = ?";
		PreparedStatement stmt = con.prepareStatement(query);
		stmt.setString(1, Id);
		
		int totalRegistrosAfetados = stmt.executeUpdate();

		if (totalRegistrosAfetados == 0) {
			System.out.println("Nao foi possivel excluir o contato referente ao id informado. Verifique o id e tente novamente");
		} else {
			System.out.println("Contato excluido com sucesso.");
		}

		stmt.close();
		con.close();
	}

	public void UpdateContato() throws SQLException{

	}
}