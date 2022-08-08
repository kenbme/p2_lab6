package Pessoa;

public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService() {
        pessoaRepository = new PessoaRepository();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        // TODO VALIDACAO
        pessoaRepository.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        // TODO VALIDACAO
        return pessoaRepository.exibirPessoa(cpf);
    }

}
