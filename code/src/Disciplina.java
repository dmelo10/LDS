import java.util.ArrayList;
import java.util.List;

public class Disciplina {
    private String nome;
    private int creditos;
    private int maxAlunos = 60;
    private int minAlunos = 3;
    private List<Aluno> alunosInscritos = new ArrayList<>();

    public Disciplina(String nome, int creditos) {
        this.nome = nome;
        this.creditos = creditos;
    }

    public void ativarDisciplina() {
        // Método para ativar disciplina
    }

    public void cancelarDisciplina() {
        // Método para cancelar disciplina
    }
}
