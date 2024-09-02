import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario {
    private static List<Aluno> alunos;
    private List<Disciplina> disciplinas;

    public static Aluno getById(String identifier) {
        for (Aluno componente : Aluno.alunos) {
            if (componente != null) {
                if (componente.getId().equals(identifier)) {
                    return componente;
                }
            }
        }
        System.out.println("Aluno " + identifier + " nao encontrado");
        return null;
    }

    public static List<Aluno> getAll() {
        return alunos;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void addToList(Aluno aluno) {
        if (alunos == null) {
            alunos = new ArrayList();
        }
        alunos.add(aluno);
    }

    public Aluno(String login, String senha, List<Disciplina> disciplinas) {
        super(login, senha);
        this.disciplinas = disciplinas;
    }

    public Aluno(String login, String senha) {
        super(login, senha);
        disciplinas = new ArrayList<>();
    }

    public Boolean matricularEmDisciplina(Disciplina disciplina) {
        if (disciplinas.size() >= 6) {
            System.out.println("Matrícula não realizada. Número máximo de disciplinas excedido.");
            return false;
        }
        for (Disciplina d : disciplinas) {
            if (!disciplina.getIsMatriculasAbertas()) {
                System.out.println("Matrícula não realizada. Disciplina fora do período de matrícula.");
                return false;
            }
            if (disciplina.getNome().equals(d.getNome())) {
                System.out.println("Matrícula não realizada. Aluno já matriculado na disciplina.");
                return false;
            }
        }
        Turma turma = Turma.getByDisciplinaId(disciplina.getId());

        if (turma == null || turma.isTurmaCheia()) {
            System.out.println("Criando nova turma");
            turma = new Turma(disciplina.getId());
            Turma.addToList(turma);
        }
        turma.addAluno(this);
        disciplinas.add(disciplina);
        return true;
    }

    public Boolean cancelarMatriculaDisciplina(Disciplina disciplina) {
        Boolean isMatriculado = false;
        if (disciplinas.size() <= 4) {
            System.out.println("Cancelamento não pode ser realizado. Número mínimo de disciplinas matriculadas é 4.");
            return false;
        }
        for (Disciplina d : disciplinas) {
            if (disciplina.getId().equals(d.getId())) {
                isMatriculado = true;
                disciplina = d;
            }
        }
        if (isMatriculado) {
            disciplinas.remove(disciplina);
            return true;
        }
        
        System.out.println("Aluno não está matriculado na disciplina.");
        
        return false;
    }

    private Double calcularMensalidade() {
        Integer numDisciplinasMatriculadas = this.disciplinas.size();
        Double valorPorDisciplina = 200.00;
        return numDisciplinasMatriculadas * valorPorDisciplina;
    }

    public void pagarDisciplinas(Scanner scan) {
        System.out.println("O valor da sua mensalidade será R$" + calcularMensalidade());
        System.out.println("Confirmar pagamento? (y/N)");

        String op = scan.nextLine();
        if(op.equals("Y")) {
            System.out.println("Pagamento realizado");
        } else {
            System.out.println("Procure a secretaria para regularizar sua mensalidade.");
        }
    }

    public void visualizarDisciplinas() {
        if(disciplinas.size() == 0) {
            System.out.println("\nAluno não está matriculado em nenhuma disciplina\n");
            return;
        }
        System.out.println("\nDisciplinas Matriculadas\n");
        for (Disciplina disciplina : disciplinas) {
            System.out.println(disciplina.getNome());            
        }
        
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    @Override
    public String toString() {

        String infos = "Login: " + this.getLogin() +
                "\tSenha: " + this.getSenha() +
                "\tDisciplinas em estudo: ";

        for (Disciplina disciplina : disciplinas) {
            infos = infos + "\n\t" + Disciplina.getById(disciplina.getId()).getNome();
        }

        return infos;
    }

    public static void setAll(List<Aluno> alunos) {
        Aluno.alunos = alunos;
    }

}
