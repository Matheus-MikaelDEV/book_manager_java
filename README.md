# 📚 Sistema de Biblioteca em Java

## ✨ Descrição

Sistema de **gerenciamento de biblioteca** desenvolvido em Java. Permite:

* Cadastro e login de usuários (Bibliotecário ou Comum)
* Adição e listagem de livros
* Registro e acompanhamento de empréstimos
* Persistência de dados em arquivos `.txt`

O sistema possui menus distintos para **bibliotecários** e **usuários comuns**, garantindo funcionalidades específicas para cada perfil.

---

## 👥 Tipos de Usuários

### Bibliotecário

* Adicionar novos livros à biblioteca
* Listar todos os livros
* Salvar todos os dados do sistema (usuários, livros e empréstimos)

### Usuário Comum

* Listar livros disponíveis
* Solicitar empréstimos de livros
* Consultar a lista de empréstimos realizados

---

## 📂 Estrutura do Projeto

```
application
├─ Main.java          # Classe principal, menu interativo

model
├─ usuario
│  ├─ Usuario.java
│  ├─ UsuarioBibliotecario.java
│  └─ UsuarioComum.java
├─ livro
│  └─ Livro.java
└─ emprestimo
   └─ Emprestimo.java

system
├─ systemUsuarios
│  └─ SystemUsuarios.java
├─ systemLivros
│  └─ SystemLivros.java
├─ systemEmprestimo
│  └─ SystemEmprestimo.java
└─ systemSave
   └─ SystemSave.java
```

---

## 💾 Persistência de Dados

O sistema utiliza **arquivos `.txt`** para armazenar informações:

| Arquivo           | Conteúdo                                                                                                |
| ----------------- | ------------------------------------------------------------------------------------------------------- |
| `usuarios.txt`    | Cadastro de usuários: `Nome,ID,Email,Senha,Tipo`                                                        |
| `livros.txt`      | Livros cadastrados: `Título,Autor,ISBN,QuantidadePaginas,DataPublicação(dd/MM/yyyy)`                    |
| `emprestimos.txt` | Empréstimos realizados: `EmailUsuario,TítuloLivro,DataEmprestimo(dd/MM/yyyy),DataDevolucao(dd/MM/yyyy)` |

---

## 📋 Exemplo de Uso

**Menu Principal:**

```
1. Registrar Usuário
2. Logar
3. Sair
Escolha:
```

**Menu do Bibliotecário:**

```
1. Add Livro
2. Listar Livros
3. Salvar Tudo
4. Sair
Escolha:
```

**Menu do Usuário Comum:**

```
1. Listar Livros
2. Pegar Livro Emprestado
3. Listar Empréstimos
4. Sair
Escolha:
```

**Formato de datas:** `dd/MM/yyyy`
**Exemplo de entrada de empréstimo:**

```
Qual o livro? Harry Potter
Qual a data de empréstimo? 01/09/2025
Qual a data de devolução? 15/09/2025
```

---

## ⚡ Observações

* O sistema diferencia **usuários comuns e bibliotecários**, exibindo menus apropriados.
* Verifica duplicidade de livros pelo **ISBN** antes de adicionar.
* Dados carregados automaticamente ao iniciar e podem ser salvos manualmente.
