package sapo.pessoa;

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

    public void alterarNomePessoa(String cpf, String novoNome) {
        pessoaService.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        pessoaService.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        pessoaService.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        pessoaService.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) {
        return pessoaService.listarComentariosPessoa(cpf);
    }

}
