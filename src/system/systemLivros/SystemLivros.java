package system.systemLivros;

import model.livro.Livro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;

public class SystemLivros {
    Scanner sc = new Scanner(System.in);

    //Construtor que já carrega os dados dos livros
    public SystemLivros() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try(BufferedReader bf = new BufferedReader(new FileReader("livros.txt"))) {
            String linha;
            while ((linha = bf.readLine()) != null) {
                String[] dados = linha.split(",");

                String titulo = dados[0];
                String autor = dados[1];
                String isbn = dados[2];
                Integer quantidadePaginas = Integer.parseInt(dados[3]);
                LocalDate data = LocalDate.parse(dados[4], formatter);

                livros.add(new Livro(titulo, autor, isbn, quantidadePaginas, data));
            }
            Collections.sort(livros);
        } catch (Exception e) {
            System.out.println("Erro ao carregar os livros: " + e.getMessage());
        }
    }

    private List<Livro> livros = new ArrayList<>();

    // responsavel por receber dados e já armazenar na lista e ordena por titulo
    public void adicionarLivro() {
        String titulo = " ";
        String autor = " ";
        String isbn = " ";
        Integer quantidadePaginas = 0;LocalDate data = null;

        try{
            System.out.print("Qual o título do livro? ");
            titulo = sc.nextLine();

            System.out.print("Qual o autor do livro? ");
            autor = sc.nextLine();

            System.out.print("Qual o ISBN do livro? ");
            isbn = sc.nextLine();

            System.out.print("Qual a quantidade de páginas do livro? ");
            quantidadePaginas = sc.nextInt();
            sc.nextLine();

            System.out.print("Qual a data de publicação do livro(dd/MM/yyyy)? ");
            data = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        } catch (InputMismatchException e) {
            System.out.println("Erro ao adicionar livro!");
            return;
        } catch (DateTimeException e) {
            System.out.println("Erro ao adicionar livro!");
            return;
        }

        for (Livro livro : livros) {
            if (livro.getIsbn().equals(isbn)) {
                System.out.println("Livro já cadastrado!");
                return;
            }
        }

        livros.add(new Livro(titulo, autor, isbn, quantidadePaginas, data));
        System.out.println("Livro cadastrado com sucesso!");

        Collections.sort(livros);
    }

    // listagem de todos os livros simples
    public void listarLivros() {
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }

    public List<Livro> getLivros() {
        return livros;
    }
}
