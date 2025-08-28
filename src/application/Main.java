package application;

import model.usuario.UsuarioBibliotecario;
import model.usuario.UsuarioComum;
import system.systemLivros.SystemLivros;
import system.systemSave.SystemSave;
import system.systemUsuarios.SystemUsuarios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("-----  Iniciando Sistema... -----");
        SystemLivros sistemaLivros = new SystemLivros();
        SystemSave sistemaSave = new SystemSave();
        SystemUsuarios sistemaUsuarios = new SystemUsuarios();

        int option = 0, option2 = 0;

        do {
            try{
                System.out.print("1. Registrar Usuário\n2. Logar\n3. Sair\nEscolha: ");
                option = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Erro ao escolher opção!");
            }

            switch (option) {
                case 1:
                    sistemaUsuarios.adicionarUsuario();
                    break;
                case 2:
                    sistemaUsuarios.logarUsuario();

                    if (sistemaUsuarios.getUsuarioLogado() instanceof UsuarioBibliotecario) {
                        do {
                            try{
                                System.out.print("1. Add Livro\n2. Listar Livros\n3. Salvar Tudo\n4. Sair\nEscolha: ");
                                option2 = sc.nextInt();
                                sc.nextLine();
                            } catch (InputMismatchException e) {
                                System.out.println("Erro ao escolher opção!");
                            }

                            switch (option2) {
                                case 1:
                                    sistemaLivros.adicionarLivro();
                                    break;
                                case 2:
                                    sistemaLivros.listarLivros();
                                    break;
                                case 3:
                                    sistemaSave.salvarTudo(sistemaLivros, sistemaUsuarios);
                                    break;
                                case 4:
                                    System.out.println("Saindo...");
                                    break;
                            }
                        } while (option2 != 4);
                    }

                    break;
                case 3:
                    System.out.println("Saindo...");
                    sc.close();
            }
        } while (option != 3);
    }
}
