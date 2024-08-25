import java.util.List;

public class Aluno extends Usuario {
    private List<Disciplina> disciplinasObrigatorias;
    private List<Disciplina> disciplinasOptativas;

    public Aluno(String nome, int id, String email, String senha) {
        super(nome, id, email, senha);
    }

    public void matricularDisciplina(Disciplina disciplina) {
        // Método para matricular disciplina
    }

    public void cancelarMatricula(Disciplina disciplina) {
        // Método para cancelar matrícula
    }
}
