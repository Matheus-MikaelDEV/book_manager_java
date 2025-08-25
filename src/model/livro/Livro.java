package model.livro;

import java.time.LocalDate;

public class Livro implements Comparable<Livro> {
    private String titulo;
    private String autor;
    private String isbn;
    private Integer quantidadePaginas;
    private LocalDate anoPublicacao;

    public Livro(String titulo, String autor, String isbn, Integer quantidadePaginas, LocalDate anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.quantidadePaginas = quantidadePaginas;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public LocalDate getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(LocalDate anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    // retorna informações do livro
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Livro: ").append(titulo).append("\n");
        sb.append("Autor: ").append(autor).append("\n");
        sb.append("ISBN: ").append(isbn).append("\n");
        sb.append("Quantidade de páginas: ").append(quantidadePaginas).append("\n");
        sb.append("Ano de publicação: ").append(anoPublicacao).append("\n");

        return sb.toString();
    }

    @Override
    public int compareTo(Livro livro) {
        return this.titulo.compareTo(livro.titulo);
    }
}
