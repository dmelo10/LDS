import java.io.Serializable;

public class Usuario implements Serializable{
    private String login;
    private String senha;

    public String getId(){
        return login;
    }

    public Usuario(String login, String senha){
        super();
        this.login = login;
        this.senha = senha;
    }

    public Usuario(){
        super();
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return this.login + "\t" + this.senha;
    }


}