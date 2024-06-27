package view.contato;

import java.sql.SQLException;
import java.util.Scanner;

import controller.dao.contato.ContatoDao;


public class RemoverContatoView {
	public static void menu(Scanner scanner) {
		String opcao;
		do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Remover um contato da lista de contatos");
            System.out.println("2. Voltar ao menu anterior");
            
            opcao = scanner.nextLine();

            if(opcao.equals("1")) {
            	remover(scanner);
            } else if (!opcao.equals("2")) {
            	System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
            }     
            
            } while (!opcao.equals("2"));
    	} 
	
	private static void remover(Scanner scanner) {  	  
	    System.out.print("Por favor, digite o id do contato a ser removido: ");	    
	    
	    try {
			ContatoDao dao = new ContatoDao();
			dao.deletePorId(scanner.nextLine());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
