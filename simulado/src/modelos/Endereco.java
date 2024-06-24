package modelos;

public class Endereco {
    private String rua;
    private String cidade;
    private int codigoPessoa;

    // Construtor
    public Endereco(String rua, String cidade, int codigoPessoa) {
        this.rua = rua;
        this.cidade = cidade;
        this.codigoPessoa = codigoPessoa;
    }

    // Getters e Setters
    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public int getCodigoPessoa() {
        return codigoPessoa;
    }

    public void setCodigoPessoa(int codigoPessoa) {
        this.codigoPessoa = codigoPessoa;
    }

    // Método para formatar dados como CSV
    public String toCSVString() {
        return rua + "," + cidade + "," + codigoPessoa;
    }
}
