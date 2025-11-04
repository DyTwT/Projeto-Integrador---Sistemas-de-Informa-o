public class Livro extends ItemBiblioteca {
    private int edicao;
    private double preco;

    public Livro(String titulo, String autor, int anoPublicacao, int edicao, double preco) {
        super(titulo, autor, anoPublicacao);
        this.edicao = edicao;
        this.preco = preco;
    }

    public int getEdicao() { return edicao; }
    public void setEdicao(int edicao) { this.edicao = edicao; }
    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public double calcularPrecoComDesconto(double percentual) {
        if (percentual < 0) percentual = 0;
        if (percentual > 100) percentual = 100;
        return preco * (1 - percentual / 100.0);
    }

    @Override
    public String toString() {
        return "Livro\n" + super.toString() +
                String.format("\nEdição: %d\nPreço: R$ %.2f", edicao, preco);
    }
}
