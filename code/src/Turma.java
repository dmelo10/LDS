import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

public class Turma implements Serializable {
    private String name;
    private String professorId;
    private String disciplinaId;
    private List<Aluno> alunos;
    private static List<Turma> turmas;
    private static int nextId = 1;
    private Integer MIN_ALUNOS = 3;
    private Integer MAX_ALUNOS = 60;

    public Turma(String disciplinaId) {
        this.disciplinaId = disciplinaId;
        this.name = generateId();
        this.alunos = new ArrayList<>();
    }

    private String generateId() {
        return "Turma " + nextId++;
    }

    public static Turma getById(String identifier) {
        for (Turma componente : Turma.turmas) {
            if (componente != null) {
                if (identifier.equals(componente.getId())) {
                    return componente;
                }
            }
        }
        System.out.println("Turma " + identifier + " nao encontrada");
        return null;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static void addToList(Turma turma) {
        if (Turma.turmas == null) {
            Turma.turmas = new ArrayList();
        }
        turmas.add(turma);
    }

    public static List<Turma> getAll() {
        return turmas;
    }

    public Turma(List<Aluno> alunos, String professor, String disciplina) {
        super();
        this.alunos = alunos;
        this.professorId = professor;
        this.disciplinaId = disciplina;
        Turma.addToList(this);
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunosIds(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Boolean addAluno(Aluno aluno) {
        if (this.alunos.size() >= MAX_ALUNOS) {
            System.out.println("Limite de alunos por turma = " + MAX_ALUNOS + ". Favor criar turma nova");
            return false;
        }
        alunos.add(aluno);
        if (this.alunos.size() >= MIN_ALUNOS) {
            Disciplina.getById(this.disciplinaId).setAtiva(true);
            ;
        }
        return true;
    }

    @Override
    public String toString() {
        String info = "ID: " + this.getId() + "\tProfessor: " + professorId + "\tDisciplina: " + disciplinaId
                + "\tAlunos:";
        for (Aluno aluno : alunos) {
            info = info + "\n\t" + aluno.getLogin();
        }
        return info;
    }

    public static void setAll(List<Turma> turmas) {
        Turma.turmas = turmas;
    }

    public static List<Turma> getTurmas() {
        return turmas;
    }

    public static void setTurmas(List<Turma> turmas) {
        Turma.turmas = turmas;
    }

    public String getId() {
        return name;
    }

    public void setId(String name) {
        this.name = name;
    }

    public String getProfessorId() {
        return professorId;
    }

    public void setProfessorId(String professorId) {
        this.professorId = professorId;
    }

    public String getDisciplinaId() {
        return disciplinaId;
    }

    public void setDisciplinaId(String disciplinaId) {
        this.disciplinaId = disciplinaId;
    }

    public Boolean isTurmaCheia() {
        if (this.alunos.size() >= MAX_ALUNOS) {
            return true;
        }
        return false;
    }

    public static Turma getByDisciplinaId(String disciplinaId) {
        for (Turma turma : turmas) {
            if (turma.getDisciplinaId().equals(disciplinaId))
                return turma;
        }
        return null;
    }

}
