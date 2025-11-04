import java.time.Year;

public class ItemBiblioteca {
    private static int nextId = 1;
    private int id;
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public ItemBiblioteca(String titulo, String autor, int anoPublicacao) {
        this.id = nextId++;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAnoPublicacao() { return anoPublicacao; }
    public void setAnoPublicacao(int anoPublicacao) { this.anoPublicacao = anoPublicacao; }

    public int calcularIdadePublicacao() {
        int anoAtual = Year.now().getValue();
        return anoAtual - anoPublicacao;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d\nTítulo: %s\nAutor: %s\nAno: %d\nIdade (anos): %d",
                id, titulo, autor, anoPublicacao, calcularIdadePublicacao()
        );
    }
}
