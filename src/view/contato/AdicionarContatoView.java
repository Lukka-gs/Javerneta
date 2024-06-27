package view.contato;

import java.sql.SQLException;
import java.util.Scanner;

import controller.dao.contato.ContatoDao;
import model.contato.Contato;

public class AdicionarContatoView {
	public static void menu(Scanner scanner) {
		String opcao;
		do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Adicionar um novo contato a lista de contatos");
            System.out.println("2. Voltar ao menu anterior");
            
            opcao = scanner.nextLine();

            if(opcao.equals("1")) {
            	adicionar(scanner);
            } else if (!opcao.equals("2")) {
            	System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
            }     
            
            } while (!opcao.equals("2"));
    	} 
	
	private static void adicionar(Scanner scanner) {
		Contato contato = new Contato();
    	  
	    System.out.print("Por favor, digite seu nome: ");
	    contato.setNome(scanner.nextLine());
	    
	    System.out.print("Por favor, digite seu email: ");
	    contato.setEmail(scanner.nextLine());
	    
	    System.out.print("Por favor, digite seu endereco: ");
	    contato.setEndereco(scanner.nextLine());
	    
	    try {
			ContatoDao dao = new ContatoDao();
			dao.add(contato);
			System.out.println("Gravacao feita no Banco de Dados");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
