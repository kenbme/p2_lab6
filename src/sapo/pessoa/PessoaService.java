package sapo.pessoa;

public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ValidadorPessoa validadorPessoa;

    public PessoaService() {
        pessoaRepository = new PessoaRepository();
        validadorPessoa = new ValidadorPessoa();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.valida(nome);
        validadorPessoa.validaHabilidades(habilidades);
        pessoaRepository.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        validadorPessoa.validaCpf(cpf);
        return pessoaRepository.exibirPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String novoNome) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.valida(novoNome);
        pessoaRepository.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.validaHabilidades(novasHabilidades);
        pessoaRepository.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        validadorPessoa.validaCpf(cpf);
        pessoaRepository.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.valida(comentario);
        validadorPessoa.valida(autorCpf);
        pessoaRepository.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) {
        validadorPessoa.validaCpf(cpf);
        return pessoaRepository.listarComentariosPessoa(cpf);
    }

}
