package sapo.pessoa;

public class PessoaService {

    private final PessoaRepository pessoaRepository;
    private final ValidadorPessoa validadorPessoa;

    public PessoaService() {
        pessoaRepository = new PessoaRepository();
        validadorPessoa = new ValidadorPessoa();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) throws IllegalArgumentException {
        validadorPessoa.valida(cpf);
        validadorPessoa.valida(nome);
        validadorPessoa.valida(habilidades);
        pessoaRepository.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        validadorPessoa.valida(cpf);
        return pessoaRepository.exibirPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String novoNome) throws IllegalArgumentException {
        validadorPessoa.valida(cpf);
        validadorPessoa.valida(novoNome);
        pessoaRepository.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) throws IllegalArgumentException {
        validadorPessoa.valida(cpf);
        validadorPessoa.valida(novasHabilidades);
        pessoaRepository.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) throws IllegalArgumentException {
        validadorPessoa.valida(cpf);
        pessoaRepository.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) throws IllegalArgumentException {
        validadorPessoa.valida(cpf);
        validadorPessoa.valida(comentario);
        validadorPessoa.valida(autorCpf);
        pessoaRepository.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) throws IllegalArgumentException {
        validadorPessoa.valida(cpf);
        return pessoaRepository.listarComentariosPessoa(cpf);
    }

}
