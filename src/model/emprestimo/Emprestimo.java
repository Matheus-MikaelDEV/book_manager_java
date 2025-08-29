package model.emprestimo;

import model.livro.Livro;
import model.usuario.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
    private Usuario usuario;
    private Livro livro;
    LocalDate emprestimo, devolucao;

    public Emprestimo(Usuario usuario, Livro livro, LocalDate emprestimo, LocalDate devolucao) {
        this.usuario = usuario;
        this.livro = livro;
        this.emprestimo = emprestimo;
        this.devolucao = devolucao;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        sb.append("Usuário: ").append(usuario.getInfo()).append("\n");
        sb.append("Livro: ").append(livro.getTitulo()).append("\n");
        sb.append("Data de empréstimo: ").append(emprestimo.format(formatter)).append("\n");
        sb.append("Data de devolução: ").append(devolucao.format(formatter)).append("\n");

        return sb.toString();
    }

    public LocalDate getEmprestimo() {
        return emprestimo;
    }

    public LocalDate getDevolucao() {
        return devolucao;
    }

    public String getTituloLivro() {
        return livro.getTitulo();
    }

    public String getEmail() {
        return usuario.getEmail();
    }
}
