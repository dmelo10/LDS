import java.io.Serializable;
import java.util.List;

public class Curso implements Serializable{
    private String nome;
    private int creditos;
    private String[] disciplinasIds;

    private static List<Curso> cursos;
    
    public static void addToList(Curso curso){
        cursos.add(curso);
    }

    public static List<Curso> getAll(){
        return cursos;
    }
    public static Curso getById(String identifier) {

        for (Curso curso : Curso.cursos) {
            if (curso != null) {
                if (curso.getId().equals(identifier)) {
                    return curso;
                };
            }
        }
        System.out.println("Componente " + identifier + " nao encontrado");
        return null;
    }
   
    public Curso(){
        this.disciplinasIds = new String[1000];
    }

    public Curso(String nome, int creditos, String[] disciplinasId){
        super();
        this.nome = nome;
        this.creditos = creditos;
        this.disciplinasIds = disciplinasId;
    }

    @Override
    public String toString(){

        String infos =  nome + "\n\tCreditos: " + String.valueOf(creditos) + "\n\tDisciplinas: ";

        for (String disciplina : disciplinasIds) {
            if(disciplina == null) break;
            infos = infos + disciplina + "\n\t\t";
        }

        return infos;
    }

    public String getId() {
        return nome;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getCreditos() {
        return creditos;
    }
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public static void setAll(List<Curso> cursos) {
        Curso.cursos = cursos;
    }
    
    public String[] getDisciplinas() {
        return disciplinasIds;
    }

}
