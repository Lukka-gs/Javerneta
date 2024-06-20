package test;

import java.sql.SQLException;
import java.util.List;

import controller.dao.contato.ContatoDao;
import model.contato.Contato;

public class TesteDaoLista {

	public static void main(String[] args) throws SQLException {
		ContatoDao cdao = new ContatoDao();
		List<Contato> contatos = cdao.getLista();
		
		for (Contato contato : contatos) { //O objeto é temporário em cada iteração
			System.out.println("Nome do contato: " + contato.getNome());
			System.out.println("E-mail do contato: " + contato.getEmail());
			System.out.println("Endereco do contato: " + contato.getEndereco());
			System.out.println("++++++++++++++++++++++++++++++++++++++");
		}

	}

}
