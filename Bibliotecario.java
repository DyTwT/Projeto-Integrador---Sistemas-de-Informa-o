import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Bibliotecario {
    private List<Livro> livros;
    private List<Revista> revistas;

    public Bibliotecario() {
        livros = new ArrayList<>();
        revistas = new ArrayList<>();
    }

    // Cadastrar novos livros
    public void cadastrarLivro() {
        try {
            String titulo = pedirString("Título do livro:");
            if (titulo == null) return;
            String autor = pedirString("Autor do livro:");
            if (autor == null) return;
            int ano = pedirInt("Ano de publicação:");
            if (ano == Integer.MIN_VALUE) return;
            int edicao = pedirInt("Edição:");
            if (edicao == Integer.MIN_VALUE) return;
            double preco = pedirDouble("Preço (ex: 49.90):");
            if (Double.isNaN(preco)) return;

            Livro l = new Livro(titulo, autor, ano, edicao, preco);
            livros.add(l);
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!\n" + l.toString());
        } catch (Exception e) {
            mostrarErro("Erro ao cadastrar livro: " + e.getMessage());
        }
    }

    // Cadastrar novas revistas
    public void cadastrarRevista() {
        try {
            String titulo = pedirString("Título da revista:");
            if (titulo == null) return;
            String autor = pedirString("Autor/responsável:");
            if (autor == null) return;
            int ano = pedirInt("Ano de publicação:");
            if (ano == Integer.MIN_VALUE) return;
            int numero = pedirInt("Número da revista:");
            if (numero == Integer.MIN_VALUE) return;
            String editora = pedirString("Editora:");
            if (editora == null) return;

            Revista r = new Revista(titulo, autor, ano, numero, editora);
            revistas.add(r);
            JOptionPane.showMessageDialog(null, "Revista cadastrada com sucesso!\n" + r.toString());
        } catch (Exception e) {
            mostrarErro("Erro ao cadastrar revista: " + e.getMessage());
        }
    }

    // Listar livros
    public void listarLivros() {
        if (livros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum livro cadastrado.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Livro l : livros) {
            sb.append(l.toString()).append("\n--------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Livros", JOptionPane.INFORMATION_MESSAGE);
    }

    // Listar revistas
    public void listarRevistas() {
        if (revistas.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhuma revista cadastrada.");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Revista r : revistas) {
            sb.append(r.toString()).append("\n--------------------\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Revistas", JOptionPane.INFORMATION_MESSAGE);
    }

    // Buscar Livro por ID
    public Livro buscarLivroId(int id) {
        for (Livro l : livros)
            if (l.getId() == id) return l;
        return null;
    }

    // Buscar Revista por ID
    public Revista buscarRevistaId(int id) {
        for (Revista r : revistas)
            if (r.getId() == id) return r;
        return null;
    }

    // Buscar por Título
    public void buscarPorTitulo() {
        String titulo = pedirString("Digite (parte do) título para busca:");
        if (titulo == null) return;
        StringBuilder sb = new StringBuilder();
        for (Livro l : livros)
            if (l.getTitulo().toLowerCase().contains(titulo.toLowerCase())) sb.append(l.toString()).append("\n---\n");
        for (Revista r : revistas)
            if (r.getTitulo().toLowerCase().contains(titulo.toLowerCase())) sb.append(r.toString()).append("\n---\n");
        if (sb.length() == 0)
            JOptionPane.showMessageDialog(null, "Nenhum item encontrado com esse título.");
        else
            JOptionPane.showMessageDialog(null, sb.toString(), "Resultados da Busca", JOptionPane.INFORMATION_MESSAGE);
    }

    // Atualizar Livro
    public void atualizarLivro() {
        int id = pedirInt("ID do livro a atualizar:");
        if (id == Integer.MIN_VALUE) return;
        Livro l = buscarLivroId(id);
        if (l == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            return;
        }

        String novoTitulo = pedirString("Novo título (deixe em branco para manter):");
        if (novoTitulo != null && !novoTitulo.trim().isEmpty()) l.setTitulo(novoTitulo);

        String novoAutor = pedirString("Novo autor (deixe em branco para manter):");
        if (novoAutor != null && !novoAutor.trim().isEmpty()) l.setAutor(novoAutor);

        String anoStr = JOptionPane.showInputDialog(null, "Novo ano (deixe em branco para manter):");
        if (anoStr != null && !anoStr.trim().isEmpty()) {
            try {
                l.setAnoPublicacao(Integer.parseInt(anoStr.trim()));
            } catch (NumberFormatException e) {
                mostrarErro("Ano inválido. Mantendo valor anterior.");
            }
        }

        String precoStr = JOptionPane.showInputDialog(null, "Novo preço (ex: 39.90) (deixe em branco para manter):");
        if (precoStr != null && !precoStr.trim().isEmpty()) {
            try {
                l.setPreco(Double.parseDouble(precoStr.trim()));
            } catch (NumberFormatException e) {
                mostrarErro("Preço inválido. Mantendo valor anterior.");
            }
        }

        JOptionPane.showMessageDialog(null, "Livro atualizado:\n" + l.toString());
    }

    // Atualizar Revista
    public void atualizarRevista() {
        int id = pedirInt("ID da revista a atualizar:");
        if (id == Integer.MIN_VALUE) return;
        Revista r = buscarRevistaId(id);
        if (r == null) {
            JOptionPane.showMessageDialog(null, "Revista não encontrada.");
            return;
        }

        String novoTitulo = pedirString("Novo título (deixe em branco para manter):");
        if (novoTitulo != null && !novoTitulo.trim().isEmpty()) r.setTitulo(novoTitulo);

        String novoAutor = pedirString("Novo autor (deixe em branco para manter):");
        if (novoAutor != null && !novoAutor.trim().isEmpty()) r.setAutor(novoAutor);

        String anoStr = JOptionPane.showInputDialog(null, "Novo ano (deixe em branco para manter):");
        if (anoStr != null && !anoStr.trim().isEmpty()) {
            try {
                r.setAnoPublicacao(Integer.parseInt(anoStr.trim()));
            } catch (NumberFormatException e) {
                mostrarErro("Ano inválido. Mantendo valor anterior.");
            }
        }

        String numStr = JOptionPane.showInputDialog(null, "Novo número (deixe em branco para manter):");
        if (numStr != null && !numStr.trim().isEmpty()) {
            try {
                r.setNumero(Integer.parseInt(numStr.trim()));
            } catch (NumberFormatException e) {
                mostrarErro("Número inválido. Mantendo valor anterior.");
            }
        }

        JOptionPane.showMessageDialog(null, "Revista atualizada:\n" + r.toString());
    }

    // Remover Livro
    public void removerLivro() {
        int id = pedirInt("ID do livro a remover:");
        if (id == Integer.MIN_VALUE) return;
        Livro l = buscarLivroId(id);
        if (l == null) {
            JOptionPane.showMessageDialog(null, "Livro não encontrado.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Confirma remoção?\n" + l.toString(), "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            livros.remove(l);
            JOptionPane.showMessageDialog(null, "Livro removido com sucesso.");
        }
    }

    // Remover Revista
    public void removerRevista() {
        int id = pedirInt("ID da revista a remover:");
        if (id == Integer.MIN_VALUE) return;
        Revista r = buscarRevistaId(id);
        if (r == null) {
            JOptionPane.showMessageDialog(null, "Revista não encontrada.");
            return;
        }
        int confirm = JOptionPane.showConfirmDialog(null, "Confirma remoção?\n" + r.toString(), "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            revistas.remove(r);
            JOptionPane.showMessageDialog(null, "Revista removida com sucesso.");
        }
    }

    // Métodos auxiliares
    private String pedirString(String mensagem) {
        String valor = JOptionPane.showInputDialog(null, mensagem);
        if (valor == null) return null;
        valor = valor.trim();
        if (valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Entrada não pode ficar vazia.");
            return pedirString(mensagem);
        }
        return valor;
    }

    private int pedirInt(String mensagem) {
        String valor = JOptionPane.showInputDialog(null, mensagem);
        if (valor == null) return Integer.MIN_VALUE;
        try {
            return Integer.parseInt(valor.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um número inteiro válido.");
            return pedirInt(mensagem);
        }
    }

    private double pedirDouble(String mensagem) {
        String valor = JOptionPane.showInputDialog(null, mensagem);
        if (valor == null) return Double.NaN;
        try {
            return Double.parseDouble(valor.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, digite um número válido (ex: 49.90).");
            return pedirDouble(mensagem);
        }
    }

    private void mostrarErro(String msg) {
        JOptionPane.showMessageDialog(null, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
