import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Loader {

    public static void init() throws IOException {
        List<Aluno> alunos = GerenciadorDeArquivos.lerArquivoDaClasse(Aluno.class);
        Aluno.setAll(alunos == null ? new ArrayList<>() : alunos);

        List<Curso> cursos = GerenciadorDeArquivos.lerArquivoDaClasse(Curso.class);
        Curso.setAll(cursos == null ? new ArrayList<>() : cursos);

        List<Disciplina> disciplinas = GerenciadorDeArquivos.lerArquivoDaClasse(Disciplina.class);
        Disciplina.setAll(disciplinas == null ? new ArrayList<>() : disciplinas);

        List<Professor> professores = GerenciadorDeArquivos.lerArquivoDaClasse(Professor.class);
        Professor.setAll(professores == null ? new ArrayList<>() : professores);

        List<Secretario> secretarios = GerenciadorDeArquivos.lerArquivoDaClasse(Secretario.class);
        Secretario.setAll(secretarios == null ? new ArrayList<>() : secretarios);

        List<Turma> turmas = GerenciadorDeArquivos.lerArquivoDaClasse(Turma.class);
        Turma.setAll(turmas == null ? new ArrayList<>() : turmas);
    }

    public static void close() {
        GerenciadorDeArquivos.salvarAll(Aluno.getAll());
        GerenciadorDeArquivos.salvarAll(Curso.getAll());
        GerenciadorDeArquivos.salvarAll(Disciplina.getAll());
        GerenciadorDeArquivos.salvarAll(Professor.getAll());
        GerenciadorDeArquivos.salvarAll(Secretario.getAll());
        GerenciadorDeArquivos.salvarAll(Turma.getAll());
    };

}
