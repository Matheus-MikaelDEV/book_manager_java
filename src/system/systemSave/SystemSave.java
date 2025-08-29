package system.systemSave;

import model.emprestimo.Emprestimo;
import model.livro.Livro;
import model.usuario.Usuario;
import model.usuario.UsuarioBibliotecario;
import system.systemEmprestimo.SystemEmprestimo;
import system.systemLivros.SystemLivros;
import system.systemUsuarios.SystemUsuarios;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class SystemSave {
    public SystemSave() {
    }

    public void salvarTudo(SystemLivros systemLivros, SystemUsuarios systemUsuarios, SystemEmprestimo systemEmprestimo) {
        try (BufferedWriter bf = new BufferedWriter(new FileWriter("livros.txt"))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (Livro livro : systemLivros.getLivros()) {
                bf.write(String.format("%s,%s,%s,%d,%s",
                        livro.getTitulo(),
                        livro.getAutor(),
                        livro.getIsbn(),
                        livro.getQuantidadePaginas(),
                        livro.getAnoPublicacao().format(formatter)));
                bf.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar os livros: " + e.getMessage(), e);
        }

        try (BufferedWriter bf = new BufferedWriter(new FileWriter("usuarios.txt"))) {
            for (Usuario usuario : systemUsuarios.getUsuarios()) {
                bf.write(String.format("%s,%d,%s,%s",
                        usuario.getNome(),
                        usuario.getId(),
                        usuario.getEmail(),
                        usuario.getSenha()));

                if (usuario instanceof UsuarioBibliotecario) {
                    bf.write(",admin");
                } else {
                    bf.write(",comum");
                }
                bf.newLine();
            }
         } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar os usuários: " + e.getMessage(), e);
        }
        
        try(BufferedWriter bf = new BufferedWriter(new FileWriter("emprestimos.txt"))) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            for (Emprestimo emprestimo : systemEmprestimo.getEmprestimos()) {
                bf.write(String.format("%s,%s,%s,%s",
                        emprestimo.getEmail(),
                        emprestimo.getTituloLivro(),
                        emprestimo.getEmprestimo().format(formatter),
                        emprestimo.getDevolucao().format(formatter)));
                bf.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao salvar os empréstimos: " + e.getMessage(), e);
        }
    }
}
