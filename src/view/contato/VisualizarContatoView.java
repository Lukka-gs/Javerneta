package view.contato;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import controller.dao.contato.ContatoDao;
import model.contato.Contato;


public class VisualizarContatoView {
	public static void menu(Scanner scanner) {
		String opcao;
		do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Visualizar contato por id");
            System.out.println("2. Visualizar contatos pela letra inicial do nome");
            System.out.println("3. Visualizar todos os contatos");
            System.out.println("4. Voltar ao menu anterior");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                	visualizarContatoPorId(scanner);
                    break;
                case "2":
                	visualizarContatosPorLetraInicial(scanner);
                    break;
                case "3":
                	visualizarTodosContatos(scanner);
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
                    break;
            }
        } while (!opcao.equals("4"));
    } 
	
	private static void visualizarTodosContatos(Scanner scanner) {  	  
		ContatoDao dao;
		try {
			dao = new ContatoDao();
			List<Contato> contatos;
			contatos = dao.getLista();
			for (Contato contato : contatos) {
				System.out.println("Nome do contato: " + contato.getNome());
				System.out.println("E-mail do contato: " + contato.getEmail());
				System.out.println("Endereco do contato: " + contato.getEndereco());
				System.out.println("++++++++++++++++++++++++++++++++++++++");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void visualizarContatosPorLetraInicial(Scanner scanner) {  	  
		ContatoDao dao;
		System.out.print("Por favor, digite a letra inicial dos contatos a serem listados: ");
		String letra = scanner.nextLine();
		
		 if (letra.length() != 1) {
	            System.out.println("Para que essa acao seja realizada uma, e apenas uma, letra deve ser informada.");
	            return;
	        }
		
		try {
			dao = new ContatoDao();
			List<Contato> contatos;
			contatos = dao.getListaPorLetra(letra);
			for (Contato contato : contatos) {
				System.out.println("Nome do contato: " + contato.getNome());
				System.out.println("E-mail do contato: " + contato.getEmail());
				System.out.println("Endereco do contato: " + contato.getEndereco());
				System.out.println("++++++++++++++++++++++++++++++++++++++");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void visualizarContatoPorId(Scanner scanner) {
		ContatoDao dao;
		System.out.print("Por favor, digite o id do contato a ser listado: ");
		try {
			dao = new ContatoDao();

			Contato contato = dao.getContatoPorId(scanner.nextLine());
		
			System.out.println("Nome do contato: " + contato.getNome());
			System.out.println("E-mail do contato: " + contato.getEmail());
			System.out.println("Endereco do contato: " + contato.getEndereco());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
