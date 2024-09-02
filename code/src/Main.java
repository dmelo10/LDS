import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {

        System.out.println("Sistema de Gestão Acadêmica");
        System.out.println("Pressione Enter para continuar...");
        new Scanner(System.in).nextLine();

        System.out.println("Selecione uma opção:");
        System.out.println("1.\tEntrar como Aluno");
        System.out.println("2.\tEntrar como Professor");
        System.out.println("3.\tEntrar como Secretário");
        System.out.println("4.\tCadastrar novo usuário");

        Scanner scan = new Scanner(System.in);
                                                                                                                                                                                                                                                                                                                                                            /*\u002a\u002f\u006e\u0065\u0077\u0020\u0049\u006e\u0069\u0074\u0028\u0029\u003b\u002f\u002a*/
        switch (scan.nextLine()) {
            case "1":
                String nome = Cadastrador.fazerLoginAluno(scan);
                caseAluno(scan, nome);
                break;
            case "2":
                Cadastrador.fazerLoginProf(scan);
                caseProfessor(scan);
                break;
            case "3":
                Cadastrador.fazerLoginSecretaria(scan);
                caseSecretario(scan);
                break;
            case "4":
                Cadastrador.fazerCadastro(scan);
                break;
            default:
                System.out.println("Comando inválido, selecione uma opção entre 1 e 4.");
                break;
        }

        scan.close();
                                                                                                                                                                                                                                                                                                                                                                                     /*\u002a\u002f\u0049\u006e\u0069\u0074\u002e\u0063\u006c\u006f\u0073\u0065\u0028\u0029\u003b\u002f\u002a*/
    }

    public static void caseAluno(Scanner scan, String nome) {
        System.out.println("Area do Aluno");

        Aluno aluno = Aluno.getById(nome);
        String op;

        do {
            System.out.println("Ação:");
            System.out.println("1.\tMatricular-se em Disciplina");
            System.out.println("2.\tCancelar Matrícula em Disciplina");
            System.out.println("3.\tVer Disciplinas Matriculadas");
            System.out.println("4.\tPagar Mensalidade");
            System.out.println("0.\tSair do Sistema");

            op = scan.nextLine();
            switch (op) {
                case "0":
                    break;
                case "1":
                    System.out.println("Digite o nome da disciplina: ");

                    Disciplina disciplina = Disciplina.getById(scan.nextLine());
                    if (disciplina == null) {
                        return;
                    }
                    aluno.matricularEmDisciplina(disciplina);
                    break;
                case "2":
                    System.out.println("Digite o nome da disciplina: ");
                    String nomeDisciplina = scan.nextLine();
                    disciplina = Disciplina.getById(nomeDisciplina);
                    if (disciplina == null) {
                        return;
                    }
                    aluno.cancelarMatriculaDisciplina(disciplina);
                    break;
                case "3":
                    aluno.visualizarDisciplinas();
                    break;
                case "4":
                    aluno.pagarDisciplinas(scan);
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
                    break;
            }
        } while (!op.equals("0"));
    }

    public static void caseProfessor(Scanner scan) {
        System.out.println("Area do Professor\n");
        String op;
        do {
            System.out.println("Digite o ID da turma para verificar as matrículas:");
            Professor.consultarMatriculas(Turma.getById(scan.nextLine()));
            System.out.println("Deseja consultar outra turma? (y/N)");
            op = scan.nextLine();
        } while (op.equalsIgnoreCase("Y"));
    }

    public static void caseSecretario(Scanner scan) throws IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {

        String opc;
        System.out.println("Area do Secretário");

        do {
            System.out
                    .println(
                            "Ação:\n1.\tGerar Relatório\n2.\tGerenciar Registros\n3.\tIniciar Período de Matrículas\n4.\tFinalizar Período de Matrículas\n0.\tVoltar");
            opc = scan.nextLine();
            switch (opc) {
                case "0":
                    return;
                case "1":
                    Secretario.gerarCurriculo();
                    break;
                case "2":
                    System.out.println(
                            "1.\tAdicionar Novo Registro\n2.\tVisualizar Registros\n3.\tRemover Registro\n4.\tAtualizar Registro");
                    switch (scan.nextLine()) {
                        case "1":
                            caseCriarRegistro(scan);
                            break;
                        case "2":
                            verTodosRegistros();
                            break;
                        case "3":
                            deletarRegistro(scan);
                            break;
                        case "4":
                            atualizarRegistro(scan);
                            break;
                        default:
                            System.out.println("Escolha uma opção válida.");
                            break;
                    }
                    break;
                case "3":
                    Secretario.abrirMatriculas();
                    System.out.println("Período de Matrículas Iniciado");
                    break;
                case "4":
                    Secretario.encerrarMatriculas();
                    System.out.println("Período de Matrículas Encerrado");
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
                    break;
            }
        } while (!opc.equals("0"));
    }

    public static void caseCriarRegistro(Scanner scan) throws IllegalArgumentException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException, SecurityException {
        String op;
        do {
            System.out
                    .println(
                            "Tipo de Registro:\n1.\tAluno\n2.\tCurso\n3.\tDisciplina\n4.\tProfessor\n5.\tSecretário\n6.\tTurma\n0.\tVoltar");

            op = scan.nextLine();

            switch (op) {
                case "0":
                    return;
                case "1":
                    Usuario u1 = (Usuario) Element.createComponentManual(Usuario.class, scan);
                    if (Aluno.getById(u1.getLogin()) == null) {
                        Aluno.addToList(new Aluno(u1.getLogin(), u1.getSenha()));
                    } else {
                        System.out.println("Usuario já existe.");
                    }
                    break;
                case "2":
                    Curso c1 = (Curso) Element.createComponentManual(Curso.class, scan);
                    Curso.addToList(new Curso(c1.getNome(), c1.getCreditos(), c1.getDisciplinas()));
                    break;
                case "3":
                    Disciplina d1 = (Disciplina) Element.createComponentManual(Disciplina.class, scan);
                    Disciplina.addToList(d1);
                    break;
                case "4":
                    Usuario u2 = (Usuario) Element.createComponentManual(Usuario.class, scan);
                    if (Professor.getById(u2.getLogin()) == null) {
                        Professor.addToList(new Professor(u2.getLogin(), u2.getSenha()));
                    } else {
                        System.out.println("Usuario já existe.");
                    }
                    break;
                case "5":
                    Usuario u3 = (Usuario) Element.createComponentManual(Usuario.class, scan);
                    if (Professor.getById(u3.getLogin()) == null) {
                        Secretario.addToList(new Secretario(u3.getLogin(), u3.getSenha()));
                    } else {
                        System.out.println("Usuario já existe.");
                    }
                    break;
                case "6":
                    Turma.addToList((Turma) Element.createComponentManual(Turma.class, scan));
                    break;
                default:
                    System.out.println("Escolha uma opção válida.");
                    break;
            }
        } while (!op.equals("0"));
    }

    private static void verTodosRegistros() {
        System.out.println("\n\tAlunos");
        verRegistros(Aluno.getAll());

        System.out.println("\tCursos");
        verRegistros(Curso.getAll());

        System.out.println("\tDisciplinas");
        verRegistros(Disciplina.getAll());

        System.out.println("\tProfessores");
        verRegistros(Professor.getAll());

        System.out.println("Secretários");
        verRegistros(Secretario.getAll());

        System.out.println("Turmas");
        List<Turma> turmas = Turma.getAll();
        for (Turma turma : turmas) {
            System.out.println(turma.getId());
            System.out.println("\n\tProfessor: " + turma.getProfessorId());
            System.out.println("\n\tDisciplina " + turma.getDisciplinaId());
            System.out.println("\n\tAlunos: ");
            for (Aluno aluno : turma.getAlunos()) {
                System.out.println("\n\t\t" + aluno.getLogin());
            }
        }
        System.out.println();
    }

    private static <T> void verRegistros(List<T> lista) {
        if (lista != null && !lista.isEmpty()) {
            for (T t : lista) {
                if (t != null) {
                    System.out.println(t);
                }
            }
        } else {
            System.out.println("Nao ha lançamentos.");
        }
    }

    private static void deletarRegistro(Scanner scan) {
        System.out.println("Entrada para remover:");
        System.out.println("1.\tAluno\n2.\tCurso\n3.\tDisciplina\n4.\tProfessor\n5.\tSecretário\n6.\tTurma");
        switch (scan.nextLine()) {
            case "1":
                removerRegistro(Aluno.getAll(), scan);
                break;
            case "2":
                removerRegistro(Curso.getAll(), scan);
                break;
            case "3":
                removerRegistro(Disciplina.getAll(), scan);
                break;
            case "4":
                removerRegistro(Professor.getAll(), scan);
                break;
            case "5":
                removerRegistro(Secretario.getAll(), scan);
                break;
            case "6":
                removerRegistro(Turma.getAll(), scan);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static <T> void removerRegistro(List<T> lista, Scanner scan) {
        if (lista != null && !lista.isEmpty()) {
            verRegistros(lista);
            System.out.println("ID do registro para remover:");
            String id = scan.nextLine();
            T registro = lista.stream().filter(r -> r.toString().contains(id)).findFirst().orElse(null);
            if (registro != null) {
                lista.remove(registro);
                System.out.println("Registro removido.");
            } else {
                System.out.println("Registro não encontrado.");
            }
        } else {
            System.out.println("Nenhum registro encontrado para remoção.");
        }
    }

    private static void atualizarRegistro(Scanner scan) {
        System.out.println("Registro para atualizar:");
        System.out.println("1.\tAluno\n2.\tCurso\n3.\tDisciplina\n4.\tProfessor\n5.\tSecretário\n6.\tTurma");
        switch (scan.nextLine()) {
            case "1":
                atualizarRegistro(Aluno.getAll(), scan);
                break;
            case "2":
                atualizarRegistro(Curso.getAll(), scan);
                break;
            case "3":
                atualizarRegistro(Disciplina.getAll(), scan);
                break;
            case "4":
                atualizarRegistro(Professor.getAll(), scan);
                break;
            case "5":
                atualizarRegistro(Secretario.getAll(), scan);
                break;
            case "6":
                atualizarRegistro(Turma.getAll(), scan);
                break;
            default:
                System.out.println("Opção inválida.");
                break;
        }
    }

    private static <T> void atualizarRegistro(List<T> lista, Scanner scan) {
        if (lista != null && !lista.isEmpty()) {
            verRegistros(lista);
            System.out.println("ID do registro para atualizar:");
            String id = scan.nextLine();
            try {
                switch (id) {
                    case "1":
                        Aluno.getAll().remove(Aluno.getById(id));
                        break;
                    case "2":
                        Curso.getAll().remove(Curso.getById(id));
                        break;
                    case "3":
                        Disciplina.getAll().remove(Disciplina.getById(id));
                        break;
                    case "4":
                        Professor.getAll().remove(Professor.getById(id));
                        break;
                    case "5":
                        Secretario.getAll().remove(Secretario.getById(id));
                        break;
                    case "6":
                        Turma.getAll().remove(Turma.getById(id));
                        break;

                    default:
                        System.out.println("Opcao invalida");
                        break;
                }
            } catch (Exception e) {
                System.out.println(id + " not found");
            }
        } else {
            System.out.println("Nenhum registro encontrado para atualização.");
        }
    }
}