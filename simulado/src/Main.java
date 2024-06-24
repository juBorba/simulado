package view;

import controller.PessoaController;

public class Main {

    public static void main(String[] args) {
        PessoaController controller = new PessoaController();
        controller.carregarDados();
        System.out.println("Arquivo combinado gerado com sucesso!");
    }
}
