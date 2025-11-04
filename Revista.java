public class Revista extends ItemBiblioteca {
    private int numero;
    private String editora;

    public Revista(String titulo, String autor, int anoPublicacao, int numero, String editora) {
        super(titulo, autor, anoPublicacao);
        this.numero = numero;
        this.editora = editora;
    }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }
    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public void incrementarNumero() { this.numero++; }

    @Override
    public String toString() {
        return "Revista\n" + super.toString() +
                String.format("\nNúmero: %d\nEditora: %s", numero, editora);
    }
}
