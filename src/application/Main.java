package application;

import system.systemLivros.SystemLivros;
import system.systemSave.SystemSave;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----  Iniciando Sistema... -----");
        SystemLivros sistema = new SystemLivros();
        SystemSave sistemaSave = new SystemSave();

        int option = 0;

        do {
            try{
                System.out.print("1. Add Livro\n2. Listar Livros\n3. Salvar Tudo\n4. Sair\nEscolha: ");
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro ao escolher opção!");
            }

            switch (option) {
                case 1:
                    sistema.adicionarLivro();
                    break;
                case 2:
                    sistema.listarLivros();
                    break;
                case 3:
                    sistemaSave.salvarTudo(sistema);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    sc.close();
                    break;
            }
        } while (option != 4);
    }
}
