# Sistema de Gerenciamento - Biblioteca (Projeto Integrador)

**Disciplina:** Introdução ao Java  
**Curso:** Sistemas de Informação - Faculdade Santíssimo Sacramento  
**Data de entrega:** 29/10/2025

---

## Descrição
Sistema simples de gerenciamento de itens de biblioteca implementado em **Java**, com interface de entrada/saída usando **JOptionPane**. O projeto demonstra conceitos de:
- Programação Orientada a Objetos (Herança, encapsulamento)
- Métodos e modularização
- Manipulação de coleções em memória (`ArrayList`)
- Operações CRUD (Create, Read, Update, Delete)

Entidades implementadas:
- `ItemBiblioteca` (superclasse)
- `Livro` (subclasse)
- `Revista` (subclasse)

---

## Funcionalidades
- Cadastrar livros e revistas
- Listar todos os livros ou revistas
- Buscar por título (busca parcial)
- Atualizar registros (livros e revistas)
- Remover registros
- Exemplo de método customizado: aplicar desconto em livro
- Todas as interações são feitas via `JOptionPane` (dialogs)

---

## Estrutura de arquivos (.java)
- `ItemBiblioteca.java` — superclasse com atributos comuns e método `calcularIdadePublicacao()`
- `Livro.java` — subclasse com atributos `isbn`, `edicao`, `preco` e método `calcularPrecoComDesconto()`
- `Revista.java` — subclasse com atributos `numero`, `editora` e método `incrementarNumero()`
- `BibliotecaManager.java` — gerencia listas, implementa CRUD e os diálogos
- `Main.java` — menu principal e loop de execução

---

## Requisitos
- Java JDK 8 ou superior
- Ambiente capaz de abrir janelas (GUI) — não funciona em modo só-terminal sem suporte a GUI

---

## Como compilar e executar (linha de comando)

1. Coloque todos os arquivos `.java` em uma pasta, por exemplo `SistemaBiblioteca/`.
2. Abra o terminal/Prompt de Comando e vá para essa pasta:
   
```bash
cd /caminho/para/SistemaBiblioteca
