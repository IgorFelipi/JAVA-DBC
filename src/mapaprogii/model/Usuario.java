
package mapaprogii.model;


public class Usuario {
    
    private String nome;
    private String login;
    private String senha;
    private String email;
    private Long id;
    private String RepSenha;

    public Long getId() {
        return id;
    }

    public String getRepSenha() {
        return RepSenha;
    }

    public void setRepSenha(String RepSenha) {
        this.RepSenha = RepSenha;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
