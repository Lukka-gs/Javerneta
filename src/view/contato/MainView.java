package view.contato;

import java.util.Scanner;

public class MainView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;
         
        do {
            System.out.println("Menu Principal:");
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Visualizar contato");
            System.out.println("3. Alterar contato");
            System.out.println("4. Deletar contato");
            System.out.print("Digite sua escolha ou 'x' para sair do programa:\n");
            opcao = scanner.nextLine().toLowerCase();

            switch (opcao) {
                case "1":
                    AdicionarContatoView.menu(scanner);
                    break;
                case "2":
                    VisualizarContatoView.menu(scanner);
                    break;
                case "3":
                    AlterarContatoView.menu(scanner);
                    break;
                case "4":
                    RemoverContatoView.menu(scanner);
                    break;
                case "x":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
                    break;
            }
        } while (!opcao.equals("x"));

        scanner.close();
    }
}