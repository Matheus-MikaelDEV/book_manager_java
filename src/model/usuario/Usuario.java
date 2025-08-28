package model.usuario;

public abstract class Usuario {
    private String nome;
    private Integer id;
    private String email;
    private String senha;

    public Usuario(String nome, Integer id, String email, String senha) {
        this.nome = nome;
        this.id = id;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }


    public abstract String getInfo();
}
