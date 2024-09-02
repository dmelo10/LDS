import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.List;
import java.io.Serializable;

public class Disciplina implements Serializable {
    private String nome;
    private Boolean ativa;
    private Boolean isMatriculasAbertas;
    private static List<Disciplina> disciplinas;

    public Disciplina() {
    }

    public static void addToList(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public static List<Disciplina> getAll() {
        return disciplinas;
    }

    public static Disciplina getById(String identifier) {
        for (Disciplina componente : Disciplina.disciplinas) {
            if (componente != null) {
                if (componente.getId().equals(identifier)) {
                    return componente;
                }
                ;
            }
        }
        return null;
    }

    public Disciplina(String nome, Boolean ativa, Boolean isMatriculasAbertas) {
        super();
        this.nome = nome;
        this.ativa = ativa;
        this.isMatriculasAbertas = isMatriculasAbertas;
        Disciplina.addToList(this);
    }

    public String getId() {
        return nome;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Boolean getIsMatriculasAbertas() {
        return isMatriculasAbertas;
    }

    public void setIsMatriculasAbertas(Boolean isMatriculasAbertas) {
        this.isMatriculasAbertas = isMatriculasAbertas;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\tAtiva: " + ativa + "\tMatriculas Abertas: " + isMatriculasAbertas;
    }

    public static void setAll(List<Disciplina> disciplinas) {
        Disciplina.disciplinas = disciplinas;
    }
}
