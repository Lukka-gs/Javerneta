import java.util.Scanner;

public class MainView {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String opcao;
         
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Visualizar contato");
            System.out.println("3. Alterar contato");
            System.out.println("4. Deletar contato");
            System.out.println("5. Sair do programa");
            System.out.print("Digite sua escolha: ");
            opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("Adicionando contato...");
                    // Chamar a classe de adição de contato
                    break;
                case "2":
                    System.out.println("Visualizando contatos...");
                    // Chamar a classe de visualização de contatos
                    break;
                case "3":
                    System.out.println("Alterando contato...");
                    // Chamar a classe de alteração de contato
                    break;
                case "4":
                    System.out.println("Deletando contato...");
                    // Chamar a classe de remoção de contato
                    break;
                case "5":
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        } while (!opcao.equals("5"));

        scanner.close();
    }
}