package pessoa;

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

    public void alterarNomePessoa(String cpf, String novoNome) {
        // TODO VALIDACAO
        pessoaRepository.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        // TODO VALIDACAO
        pessoaRepository.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        // TODO VALIDACAO
        pessoaRepository.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        // TODO VALIDACAO
        pessoaRepository.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) {
        // TODO VALIDACAO
        return pessoaRepository.listarComentariosPessoa(cpf);
    }

}
