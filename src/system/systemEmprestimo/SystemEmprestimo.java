package system.systemEmprestimo;

import model.emprestimo.Emprestimo;
import model.livro.Livro;
import model.usuario.Usuario;
import system.systemLivros.SystemLivros;
import system.systemUsuarios.SystemUsuarios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SystemEmprestimo {
    List<Emprestimo> emprestimos = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    SystemUsuarios systemUsuarios;
    SystemLivros systemLivros;

    public SystemEmprestimo(SystemUsuarios systemUsuarios, SystemLivros systemLivros) {
        this.systemUsuarios = systemUsuarios;
        this.systemLivros = systemLivros;

        try(BufferedReader bf = new BufferedReader(new FileReader("emprestimos.txt"))) {
            String linha;
            while ((linha = bf.readLine()) != null) {
                String[] dados = linha.split(",");
                for (Livro livro : systemLivros.getLivros()) {
                    if (livro.getTitulo().equalsIgnoreCase(dados[1])) {
                        for (Usuario usuario : systemUsuarios.getUsuarios()) {
                            if (usuario.getEmail().equalsIgnoreCase(dados[0])) {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                emprestimos.add(new Emprestimo(usuario, livro, LocalDate.parse(dados[2], formatter), LocalDate.parse(dados[3], formatter)));
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os empréstimos: " + e.getMessage());
        }
    }

    public void adicionarEmprestimo() {

        String nomeLivro;
        LocalDate dataEmprestimo, dataDevolucao;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            System.out.print("Qual o livro? ");
            nomeLivro = sc.nextLine();

            System.out.print("Qual a data de empréstimo? ");
            dataEmprestimo = LocalDate.parse(sc.nextLine(), formatter);

            System.out.print("Qual a data de devolução? ");
            dataDevolucao = LocalDate.parse(sc.nextLine(), formatter);
        } catch (InputMismatchException e) {
            System.out.println("Erro ao adicionar empréstimo!");
            sc.nextLine();
            return;
        }

        for (Livro livro : systemLivros.getLivros()) {
            if (livro.getTitulo().equalsIgnoreCase(nomeLivro)) {
                emprestimos.add(new Emprestimo(systemUsuarios.getUsuarioLogado(), livro, dataEmprestimo, dataDevolucao));
                return;
            }
        }
    }

    public void listarEmprestimos() {
        for (Emprestimo emprestimo : emprestimos) {
            System.out.println(emprestimo.getInfo());
        }
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
