import java.util.List;

public class Secretario extends Usuario {

    private static List<Secretario> secretarios;

    public static Secretario getById(String identifier) {

        for (Secretario componente : Secretario.secretarios) {
            if (componente != null) {
                if (identifier.equals(componente.getId())) {
                    return componente;
                }
                ;
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }

    public static void addToList(Secretario secretario) {
        secretarios.add(secretario);
    }

    public static List<Secretario> getAll() {
        return secretarios;
    }

    public Secretario(String login, String senha) {
        super(login, senha);

    }

    public static void gerarCurriculo() {

        if (Curso.getAll() != null && !Curso.getAll().isEmpty()) {
            System.out.println("=========Cursos=========");
            for (Curso curso : Curso.getAll()) {
                System.out.println(curso.toString());
            }
        } else {
            System.out.println("Nao ha cursos no momento");
        }

        if (Professor.getAll() != null && !Professor.getAll().isEmpty()) {
            System.out.println("========Professores========");
            for (Professor professor : Professor.getAll()) {
                System.out.println(professor.getId());
            }
        } else {
            System.out.println("Nao ha professores no momento");
        }
    }

    public static void setAll(List<Secretario> secretarios) {
        Secretario.secretarios = secretarios;
    }

    public static Boolean abrirMatriculas() {
        List<Disciplina> disciplinas = Disciplina.getAll();
        if (disciplinas == null || disciplinas.size() == 0)
            return false;
        for (Disciplina disciplina : disciplinas) {
            disciplina.setIsMatriculasAbertas(true);
        }
        return true;
    }

    public static Boolean encerrarMatriculas() {
        List<Disciplina> disciplinas = Disciplina.getAll();
        if (disciplinas == null || disciplinas.size() == 0)
            return false;
        for (Disciplina disciplina : disciplinas) {
            disciplina.setIsMatriculasAbertas(false);
        }
        return true;
    }
}
