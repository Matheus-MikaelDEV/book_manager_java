package model.usuario;

public class UsuarioComum  extends  Usuario{
    public UsuarioComum(String nome, Integer id, String email, String senha) {
        super(nome, id, email, senha);
    }

    @Override
    public String getInfo() {
        return "Usuário Comum: " + getNome() + " (ID: " + getId() + ", Email: " + getEmail() + ")";
    }

}
