package model.usuario;

public class UsuarioBibliotecario extends Usuario{
    public UsuarioBibliotecario(String nome, Integer id, String email, String senha) {
        super(nome, id, email, senha);
    }

    @Override
    public String getInfo() {
        return "Bibliotecário: " + getNome() + " (ID: " + getId() + ", Email: " + getEmail() + ")";
    }
}
