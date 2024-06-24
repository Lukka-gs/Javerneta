package view.contato;

import java.util.Scanner;

public class MainView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean menuAtivo = true;
        
        //utilizar um do while. Ter 4 opções, insere, lista, altera, remove e sair. Ter uma view para cada opção
        while (menuAtivo) {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Inserir contato");
            System.out.println("2. Listar toda tabela");
            System.out.println("3. Listar nomes comecam com letra");
            System.out.println("4. Lista contato por id");
            System.out.println("5. Alterar os dados nome e/ou email e/ou endereco por id");
            System.out.println("6. Remover contato por id");
            System.out.println("Digite 'x' para terminar o programa.");
            System.out.print("Digite sua escolha: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Executando Opcao 1...");
                    // Coloque o código da Ação 1 aqui
                    break;
                case "2":
                    System.out.println("Executando Opcao 2...");
                    // Coloque o código da Ação 2 aqui
                    break;
                case "3":
                    System.out.println("Executando Opcao 3...");
                    // Coloque o código da Ação 3 aqui
                    break;
                case "4":
                    System.out.println("Executando Opcao 4...");
                    // Coloque o código da Ação 4 aqui
                    break;
                case "5":
                    System.out.println("Executando Opcao 5...");
                    // Coloque o código da Ação 5 aqui
                    break;
                case "6":
                    System.out.println("Executando Opcao 6...");
                    // Coloque o código da Ação 5 aqui
                    break;
                case "x":
                	menuAtivo = false;
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }

        scanner.close();
    }
}
