import java.util.List;

public class Professor extends Usuario {
    private List<Disciplina> disciplinas;

    public Professor(String nome, int id, String email, String senha) {
        super(nome, id, email, senha);
    }

    public void consultarAlunos(Disciplina disciplina) {
        // Método para consultar alunos de uma disciplina
    }
}
