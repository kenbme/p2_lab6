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
    
    public void cadastraAluno(String CPF, String nome, String[] habilidades, String matricula, String periodo) {
    	validadorPessoa.validaCpf(CPF);
    	validadorPessoa.valida(new String[]{nome, matricula, periodo});
    	validadorPessoa.valida(habilidades);
    	pessoaService.cadastraAluno(CPF, nome, habilidades, matricula, periodo);
    }
    
    public void cadastraProfessor(String CPF, String nome, String[] habilidades, String codSIAPE, String[] disciplinas) {
    	validadorPessoa.validaCpf(CPF);
    	validadorPessoa.valida(habilidades);
    	validadorPessoa.valida(disciplinas);
    	validadorPessoa.valida(new String[]{nome, codSIAPE});
    	pessoaService.cadastraProfessor(CPF, nome, habilidades, codSIAPE, disciplinas);
    }
    
    public void defineFuncaoProfessor(String CPF, String codSIAPE, String[] disciplinas) {
    	validadorPessoa.validaCpf(CPF);
    	validadorPessoa.valida(disciplinas);
    	validadorPessoa.valida(codSIAPE);
    	pessoaService.defineFuncaoProfessor(CPF,  codSIAPE,  disciplinas);
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
