package view.contato;

import java.sql.SQLException;
import java.util.Scanner;

import controller.dao.contato.ContatoDao;
import model.contato.Contato;

public class AtualizarContatoView {
    public static void menu(Scanner scanner) {
        String opcao;
        do {
            System.out.println("Escolha uma opcao:");
            System.out.println("1. Atualizar um contato existente");
            System.out.println("2. Voltar ao menu anterior");

            opcao = scanner.nextLine();

            if(opcao.equals("1")) {
                atualizar(scanner);
            } else if (!opcao.equals("2")) {
                System.out.println("Opcao invalida. Por favor, escolha uma opcao valida.");
            }

        } while (!opcao.equals("2"));
    }

    private static void atualizar(Scanner scanner) {
        System.out.print("Digite o Id do contato que deseja atualizar: ");
        String id = scanner.nextLine();

        try {
            ContatoDao dao = new ContatoDao();
            Contato contatoExistente = dao.getContatoPorId(id);

            if (contatoExistente != null) {
                System.out.println("Digite os novos dados do contato:");

                Contato contatoAtualizado = new Contato();
                //contatoAtualizado.setId(id); id (não alterado)

                System.out.print("Novo nome (ou deixe em branco para manter o atual " + contatoExistente.getNome() + "): ");
                String novoNome = scanner.nextLine();
                if (!novoNome.isEmpty()) {
                    contatoAtualizado.setNome(novoNome);
                } else {
                    contatoAtualizado.setNome(contatoExistente.getNome());
                }

                System.out.print("Novo email (ou deixe em branco para manter o atual " + contatoExistente.getEmail() + "): ");
                String novoEmail = scanner.nextLine();
                if (!novoEmail.isEmpty()) {
                    contatoAtualizado.setEmail(novoEmail);
                } else {
                    contatoAtualizado.setEmail(contatoExistente.getEmail());
                }

                System.out.print("Novo endereco (ou deixe em branco para manter o atual " + contatoExistente.getEndereco() + "): ");
                String novoEndereco = scanner.nextLine();
                if (!novoEndereco.isEmpty()) {
                    contatoAtualizado.setEndereco(novoEndereco);
                } else {
                    contatoAtualizado.setEndereco(contatoExistente.getEndereco());
                }

                dao.UpdateContato(contatoAtualizado);
                System.out.println("Contato atualizado com sucesso.");
            } else {
                System.out.println("Nenhum contato encontrado com o ID fornecido.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
