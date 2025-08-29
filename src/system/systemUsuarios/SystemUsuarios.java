package system.systemUsuarios;

import model.usuario.Usuario;
import model.usuario.UsuarioBibliotecario;
import model.usuario.UsuarioComum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemUsuarios {
    List<Usuario> usuarios = new ArrayList<>();

    Usuario usuarioLogado;

    public SystemUsuarios() {
        try (BufferedReader bf = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linha;

            while ((linha = bf.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                Integer id = Integer.parseInt(dados[1]);
                String email = dados[2];
                String senha = dados[3];
                String tipo = dados[4];

                if (tipo.equalsIgnoreCase("admin")) {
                    usuarios.add(new UsuarioBibliotecario(nome, id, email, senha));
                } else if(tipo.equalsIgnoreCase("comum")) {
                    usuarios.add(new UsuarioComum(nome, id, email, senha));
                }

            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar os usuários:" + e.getMessage());
        }
    }

    Scanner sc =  new Scanner(System.in);

    public void adicionarUsuario() {
        String nome = " ", email = " ", tipo = " ", senha = " ";
        Integer id = 0;

        try {
            System.out.print("Qual o nome do usuário? ");
            nome = sc.nextLine();

            System.out.print("Qual o email do usuário? ");
            email = sc.nextLine();

            System.out.print("Qual a senha? ");
            senha = sc.nextLine();

            System.out.print("admin ou comum? ");
            tipo = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao adicionar usuário!");
            sc.nextLine();
            return;
        }

        if (tipo.equalsIgnoreCase("admin")) {
            usuarios.add(new UsuarioBibliotecario(nome, usuarios.size() + 1, email, senha));
        } else if (tipo.equalsIgnoreCase("comum")) {
            usuarios.add(new UsuarioComum(nome, usuarios.size() + 1, email, senha));
        } else {
            System.out.println("Tipo de usuário inválido!");
            return;
        }

        System.out.println("Usuário cadastrado com sucesso!");
    }

    public void logarUsuario() {
        String email = " ", senha = " ";

        System.out.print("Email: ");
        email = sc.nextLine();

        System.out.print("Senha: ");
        senha = sc.nextLine();

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                System.out.println("Usuário logado com sucesso!");
                return;
            }
        }
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }
}
