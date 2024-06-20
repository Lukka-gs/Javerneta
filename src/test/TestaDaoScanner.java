package test;

import java.sql.SQLException;
import java.util.Scanner;

import controller.dao.contato.ContatoDao;
import model.contato.Contato;

public class TestaDaoScanner {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Contato contato = new Contato();
	  
	    System.out.print("Por favor, digite seu nome: ");
	    contato.setNome(scanner.nextLine());
	    
	    System.out.print("Por favor, digite seu email: ");
	    contato.setEmail(scanner.nextLine());
	    
	    System.out.print("Por favor, digite seu endereco: ");
	    contato.setEndereco(scanner.nextLine());
	    
	    try {
			ContatoDao dao = new ContatoDao();
			dao.adiciona(contato);
			System.out.println("Gravação feita no Banco de Dados");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    scanner.close();
	}
}
