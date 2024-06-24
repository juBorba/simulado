package modelos;

public class Pessoa {
    private int codigo;
    private String nome;

    // Construtor
    public Pessoa(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para formatar dados como CSV
    public String toCSVString() {
        return codigo + "," + nome;
    }
}
