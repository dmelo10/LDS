public abstract class Usuario {
    private String nome;
    private int id;
    private String email;
    private String senha;

    public Usuario(String nome, int id, String email, String senha) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public boolean login(String senha) {
        return this.senha.equals(senha);
    }
}
