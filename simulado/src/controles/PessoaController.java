
package controles;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import model.Endereco;
import model.Pessoa;

public class PessoaController {

    private List<Pessoa> pessoas;
    private List<Endereco> enderecos;

    public PessoaController() {
        this.pessoas = new ArrayList<>();
        this.enderecos = new ArrayList<>();
    }

    public void carregarDados() {
        carregarPessoas();
        carregarEnderecos();
        combinarDados();
        salvarArquivoCombinado();
    }

    private void carregarPessoas() {
        try (CSVReader reader = new CSVReader(new FileReader("src/arquivo_pessoas.csv"))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                int codigo = Integer.parseInt(linha[0]);
                String nome = linha[1];
                pessoas.add(new Pessoa(codigo, nome));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarEnderecos() {
        try (CSVReader reader = new CSVReader(new FileReader("src/arquivo_enderecos.csv"))) {
            String[] linha;
            while ((linha = reader.readNext()) != null) {
                String rua = linha[0];
                String cidade = linha[1];
                int codigoPessoa = Integer.parseInt(linha[2]);
                enderecos.add(new Endereco(rua, cidade, codigoPessoa));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void combinarDados() {
        for (Pessoa pessoa : pessoas) {
            for (Endereco endereco : enderecos) {
                if (endereco.getCodigoPessoa() == pessoa.getCodigo()) {
                    pessoa.adicionarEndereco(endereco);
                    break; // Como cada pessoa tem um único endereço no exemplo, podemos interromper após encontrar o correspondente
                }
            }
        }
    }

    private void salvarArquivoCombinado() {
        try (CSVWriter writer = new CSVWriter(new FileWriter("src/arquivo_combinado.csv"))) {
            for (Pessoa pessoa : pessoas) {
                writer.writeNext(pessoa.toCSVString().split(","));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
