
import java.util.List;
import java.util.ArrayList;

public class Professor extends Usuario {

    private static List<Professor> professores;

    public static Professor getById(String identifier) {

        for (Professor componente : Professor.professores) {
            if (componente != null) {
                if (componente.getId().equals(identifier)) {
                    return componente;
                }
                ;
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }

    public static List<Professor> getAll() {
        return professores;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void addToList(Professor professor) {
        if (professores == null) {
            professores = new ArrayList();
        }
        professores.add(professor);
    }

    public Professor(String login, String senha) {
        super(login, senha);
    }

    public Professor() {
        super();
    }

    public static void consultarMatriculas(Turma turma) {
        try {

            List<Aluno> alunos = turma.getAlunos();

            if (alunos.size() <= 0) {
                System.out.println("Não há alunos matriculados nessa diciplina");
            } else {
                System.out.println("Alunos matriculados na turma da diciplina " + turma.getId() + ": ");

                for (Aluno aluno : alunos) {
                    System.out.println(aluno.getLogin());
                }
            }
        } catch (Exception e) {
            System.out.println("Nao foi possivel consultar matriculas");
        }
    }

    public static void setAll(List<Professor> professores) {
        Professor.professores = professores;
    }

}
