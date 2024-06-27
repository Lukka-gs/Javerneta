package view.contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.dao.contato.ContatoDao;
import model.contato.Contato;


public class AlterarContatoView {
	public static void menu(Scanner scanner) {
		String opcao;
		do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Alterar um contato da lista de contatos");
            System.out.println("2. Voltar ao menu anterior");
            
            opcao = scanner.nextLine();

            if(opcao.equals("1")) {
            	alterar(scanner);
            } else if (!opcao.equals("2")) {
            	System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
            }     
            
            } while (!opcao.equals("2"));
    	}
	
	private static void alterar(Scanner scanner) {  	  
		ContatoDao dao;
		System.out.print("Por favor, digite o id do contato a ser listado: ");
		try {
			dao = new ContatoDao();
			String id = scanner.nextLine();
			Contato contato = dao.getPorId(id);
		
			System.out.println("Nome do contato: " + contato.getNome());
			System.out.println("Informe o novo nome do contato ou deixe em branco caso não queira modificar: ");
			String input = scanner.nextLine();
	        contato.setNome(input.isEmpty() ? contato.getNome() : input);
			
			System.out.println("E-mail do contato: " + contato.getEmail());
			System.out.println("Informe o novo e-mail do contato ou deixe em branco caso não queira modificar: ");
			input = scanner.nextLine();
	        contato.setEmail(input.isEmpty() ? contato.getEmail() : input);
	        
	        
			System.out.println("Endereco do contato: " + contato.getEndereco());
			System.out.println("Informe o novo endereço do contato ou deixe em branco caso não queira modificar: ");
			input = scanner.nextLine();
	        contato.setEndereco(input.isEmpty() ? contato.getEndereco() : input);
	        
	        dao = new ContatoDao();
	        dao.update(contato, id);
	        
	        dao = new ContatoDao();
	        contato = dao.getPorId(id);
	        System.out.println("Nome do contato: " + contato.getNome());
			System.out.println("E-mail do contato: " + contato.getEmail());
			System.out.println("Endereco do contato: " + contato.getEndereco());
			System.out.println("++++++++++++++++++++++++++++++++++++++");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
