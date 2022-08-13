package sapo.pessoa;

public class PessoaController {

    private final PessoaService pessoaService;
    private final ValidadorPessoa validadorPessoa;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
        validadorPessoa = new ValidadorPessoa();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.valida(nome);
        validadorPessoa.validaHabilidades(habilidades);
        pessoaService.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        validadorPessoa.validaCpf(cpf);
        return pessoaService.exibirPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String novoNome) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.valida(novoNome);
        pessoaService.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.validaHabilidades(novasHabilidades);
        pessoaService.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        validadorPessoa.validaCpf(cpf);
        pessoaService.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        validadorPessoa.validaCpf(cpf);
        validadorPessoa.valida(comentario);
        validadorPessoa.valida(autorCpf);
        pessoaService.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) {
        validadorPessoa.validaCpf(cpf);
        return pessoaService.listarComentariosPessoa(cpf);
    }

}
