import java.util.Scanner;

public class Cadastrador {

    public static String fazerLoginAluno(Scanner scan) {
        System.out.println("Digite seu nome:");

        String nome = scan.nextLine();

        Aluno aluno = Aluno.getById(nome);

        if (aluno == null) {
            System.out.println("Login nao encontrado");
            System.exit(0);
        }

        System.out.println("Digite a senha:");

        String senha = scan.nextLine();

        if (!senha.equals(aluno.getSenha())) {
            System.out.println("Senha incorreta");
            System.exit(0);
        }

        System.out.println("Bem vindo, " + nome);
        return nome;
    }

    public static void fazerLoginProf(Scanner scan) {
        System.out.println("Digite seu nome:");

        String nome = scan.nextLine();

        Professor prof = Professor.getById(nome);

        if (prof == null) {
            System.out.println("Login nao encontrado");
            System.exit(0);
        }

        System.out.println("Digite a senha:");

        String senha = scan.nextLine();

        if (!senha.equals(prof.getSenha())) {
            System.out.println("Senha incorreta");
            System.exit(0);
        }

        System.out.println("Bem vindo, " + nome);
    }

    public static void fazerLoginSecretaria(Scanner scan) {
        System.out.println("Digite seu nome:");

        String nome = scan.nextLine();

        Secretario secretario = Secretario.getById(nome);

        if (secretario == null) {
            System.out.println("Login nao encontrado");
            System.exit(0);
        }

        System.out.println("Digite a senha:");

        String senha = scan.nextLine();

        if (!senha.equals(secretario.getSenha())) {
            System.out.println("Senha incorreta");
            System.exit(0);
        }

        System.out.println("Logado como: " + nome);
    }

    public static void fazerCadastro(Scanner scan) {
        String op;
        try {
            do {
                System.out
                        .println("Qual é o tipo de registro?\n1.\tAluno\n2.\tProfessor\n3.\tSecretario\n0.\tEncerrar programa");
                op = scan.nextLine();
                switch (op) {
                    case "0":
                        break;
                    case "1":
                        Usuario u1 = (Usuario) Element.createComponentManual(Usuario.class, scan);
                        if (Aluno.getById(u1.getLogin()) == null) {
                            Aluno.addToList(new Aluno(u1.getLogin(), u1.getSenha()));
                        } else {
                            System.out.println("Login já cadastrado");
                        }
                        break;
                    case "2":
                        Usuario u2 = (Usuario) Element.createComponentManual(Usuario.class, scan);
                        if (Professor.getById(u2.getLogin()) == null) {
                            Professor.addToList(new Professor(u2.getLogin(), u2.getSenha()));
                        } else {
                            System.out.println("Login já cadastrado");
                        }
                        break;
                    case "3":
                        Usuario u3 = (Usuario) Element.createComponentManual(Usuario.class, scan);
                        if (Professor.getById(u3.getLogin()) == null) {
                            Secretario.addToList(new Secretario(u3.getLogin(), u3.getSenha()));
                        } else {
                            System.out.println("Login já cadastrado");
                        }
                        break;
                }
            } while (!op.equals("0"));
        } catch (Exception e) {
            System.err.println("Erro ao fazer cadastro:" + e);
        }
    }
}