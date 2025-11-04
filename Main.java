import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Bibliotecario manager = new Bibliotecario();
        String[] opcoes = {
                "1 - Cadastrar Livro",
                "2 - Cadastrar Revista",
                "3 - Listar Livros",
                "4 - Listar Revistas",
                "5 - Buscar por Título",
                "6 - Atualizar Livro",
                "7 - Atualizar Revista",
                "8 - Remover Livro",
                "9 - Remover Revista",
                "10 - Aplicar desconto em livro (exemplo de método)",
                "0 - Sair"
        };

        while (true) {
            String escolha = (String) JOptionPane.showInputDialog(
                    null,
                    "Sistema de Biblioteca - Menu Principal",
                    "Menu",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            if (escolha == null) {
                int conf = JOptionPane.showConfirmDialog(null, "Deseja sair do sistema?", "Sair", JOptionPane.YES_NO_OPTION);
                if (conf == JOptionPane.YES_OPTION) break;
                else continue;
            }

            switch (escolha.charAt(0)) {
                case '1': manager.cadastrarLivro(); break;
                case '2': manager.cadastrarRevista(); break;
                case '3': manager.listarLivros(); break;
                case '4': manager.listarRevistas(); break;
                case '5': manager.buscarPorTitulo(); break;
                case '6': manager.atualizarLivro(); break;
                case '7': manager.atualizarRevista(); break;
                case '8': manager.removerLivro(); break;
                case '9': manager.removerRevista(); break;
                default:
                    if (escolha.startsWith("10")) {
                        String idStr = JOptionPane.showInputDialog("ID do livro para aplicar desconto:");
                        if (idStr == null) break;
                        try {
                            int id = Integer.parseInt(idStr.trim());
                            Livro l = manager.buscarLivroId(id);
                            if (l == null) {
                                JOptionPane.showMessageDialog(null, "Livro não encontrado.");
                                break;
                            }
                            String percStr = JOptionPane.showInputDialog("Percentual de desconto (ex: 10 para 10%):");
                            if (percStr == null) break;
                            double perc = Double.parseDouble(percStr.trim());
                            double precoFinal = l.calcularPrecoComDesconto(perc);
                            JOptionPane.showMessageDialog(null, "Preço com desconto: R$ " + String.format("%.2f", precoFinal));
                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Entrada inválida.");
                        }
                    } else if (escolha.startsWith("0")) {
                        int conf = JOptionPane.showConfirmDialog(null, "Deseja realmente sair?", "Sair", JOptionPane.YES_NO_OPTION);
                        if (conf == JOptionPane.YES_OPTION) System.exit(0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Opção não reconhecida.");
                    }
                    break;
            }
        }
    }
}
