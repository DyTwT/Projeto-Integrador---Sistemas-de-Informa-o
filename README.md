# 📚 Sistema de Biblioteca em Java

## 🧩 Sobre o Projeto
Este projeto foi desenvolvido como parte da disciplina **Linguagem de Programação** do curso de **Sistemas de Informação**.  
O objetivo é simular o funcionamento básico de um **sistema de gerenciamento de biblioteca**, permitindo o **cadastro, listagem, busca, atualização e remoção de livros e revistas**.

A aplicação foi desenvolvida em **Java**, utilizando a biblioteca **Swing** para interações gráficas com o usuário (caixas de diálogo via `JOptionPane`).

---

## ⚙️ Funcionalidades Principais

### 📘 Livros
- Cadastrar novos livros (título, autor, ano, edição e preço)  
- Listar todos os livros cadastrados  
- Atualizar informações de um livro existente  
- Remover livros do sistema  
- Calcular preço com desconto (função demonstrativa)  

### 📰 Revistas
- Cadastrar novas revistas (título, autor/responsável, ano, número e editora)  
- Listar revistas cadastradas  
- Atualizar dados de revistas  
- Remover revistas  

### 🔎 Busca
- Buscar livros e revistas pelo **título** (total ou parcial)

---

## 🧠 Estrutura do Projeto

| Classe | Descrição |
|--------|------------|
| **Main** | Classe principal que contém o menu e controla o fluxo da aplicação |
| **Bibliotecario** | Gerencia listas de livros e revistas, e executa operações de CRUD |
| **ItemBiblioteca** | Classe base com atributos e métodos comuns (título, autor, ano) |
| **Livro** | Classe filha que representa um livro, incluindo edição e preço |
| **Revista** | Classe filha que representa uma revista, incluindo número e editora |

---

## 💻 Tecnologias Utilizadas
- **Linguagem:** Java  
- **IDE:** IntelliJ IDEA Community  
- **Biblioteca gráfica:** `javax.swing`  
- **Paradigma:** Programação Orientada a Objetos (POO)

---

## ▶️ Como Executar

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seuusuario/nome-do-repositorio.git
2. Abra o projeto no IntelliJ IDEA (ou em outra IDE de sua preferência).
3. Compile e execute a classe principal:
   ```bash
   Main.java
4. Utilize o menu exibido nas janelas de diálogo para navegar entre as opções do sistema.

---

## 👩‍💻 Autora
- **Andressa de Pinho Barreto**
- **🎓 Estudante de Sistemas de Informação**
- **📘 Disciplina:** Linguagem de Programação 
- **📚 Professor:** Joan Marcel Couto de Melo
- **📅 Projeto Integrador - II Unidade**

Este projeto tem fins educacionais e foi desenvolvido como prática dos conceitos de Programação Orientada a Objetos (POO) em Java.

---

## 🧠 Conceitos Envolvidos

- Herança e polimorfismo
- Encapsulamento
- Manipulação de listas (ArrayList)
- Interfaces gráficas com Swing (JOptionPane)
- Estrutura de controle e tratamento de exceções
