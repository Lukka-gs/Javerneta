package test;

import java.sql.SQLException;

import controller.dao.contato.ContatoDao;
import model.contato.Contato;

public class TesteDaoInsere {
	public static void main(String[] args) {
		Contato contato = new Contato();
		contato.setNome("Maria");
		contato.setEmail("maria@gmail.com");
		contato.setEndereco("Av Brasil, 500");
		
		try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação feita no Banco de Dados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
