package atividades;
import java.util.Scanner;

// Estrutura para armazenar dados de usuário
class Usuario {
    String nome;
    String cpf;
    String email;

    public Usuario(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}

public class QuartoExercicio {
    // Função para cadastrar usuário
    public static Usuario cadastrarUsuario(Scanner sc) {
        System.out.print("Digite o nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = sc.nextLine();
        System.out.print("Digite o email: ");
        String email = sc.nextLine();
        return new Usuario(nome, cpf, email);
    }
    
    // Função para consultar usuário por CPF
    public static void consultarUsuario(Usuario[] usuarios, Scanner sc) {
        System.out.print("Digite o CPF para consulta: ");
        String cpfConsulta = sc.nextLine();
        
        boolean encontrado = false;
        for (Usuario usuario : usuarios) {
            if (usuario != null && usuario.cpf.equals(cpfConsulta)) {
                System.out.println("\n--- Dados do Usuário ---");
                System.out.println("Nome: " + usuario.nome);
                System.out.println("CPF: " + usuario.cpf);
                System.out.println("Email: " + usuario.email);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("Usuário com o CPF " + cpfConsulta + " não encontrado.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Usuario[] usuarios = new Usuario[3];
        int numUsuariosCadastrados = 0;
        int opcao;

        System.out.println("*** Gerenciamento de Usuários ***");
        
        do {
            System.out.println("\n--- Menu ---");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Consultar usuário por CPF");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); // Limpar o buffer do scanner

            switch (opcao) {
                case 1:
                    if (numUsuariosCadastrados < 3) {
                        System.out.println("\n--- Cadastro de Novo Usuário ---");
                        usuarios[numUsuariosCadastrados] = cadastrarUsuario(sc);
                        numUsuariosCadastrados++;
                        System.out.println("Usuário cadastrado com sucesso!");
                    } else {
                        System.out.println("\nNúmero máximo de usuários (3) já foi atingido.");
                    }
                    break;
                case 2:
                    if (numUsuariosCadastrados > 0) {
                        consultarUsuario(usuarios, sc);
                    } else {
                        System.out.println("\nNenhum usuário cadastrado ainda.");
                    }
                    break;
                case 0:
                    System.out.println("\nSaindo do programa. Até mais!");
                    break;
                default:
                    System.out.println("\nOpção inválida. Tente novamente.");
            }
        } while (opcao != 0);

        sc.close();
    }
}