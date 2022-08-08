package Pessoa;

public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        pessoaService.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        return pessoaService.exibirPessoa(cpf);
    }
}
