import Atividade.AtividadeController;
import Atividade.AtividadeService;
import Pessoa.PessoaController;
import Pessoa.PessoaService;
import Tarefa.TarefaController;
import Tarefa.TarefaService;

public class Facade {

    private final PessoaController pessoaController;
    private final AtividadeController atividadeController;
    private final TarefaController tarefaController;

    // TODO SEPARAR RESPONSABILIDADES
    public Facade() {
        pessoaController = new PessoaController(new PessoaService());
        atividadeController = new AtividadeController(new AtividadeService());
        tarefaController = new TarefaController(new TarefaService());
    }

    // PESSOA
    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {

    }

    public String exibirPessoa(String cpf) {
        throw new UnsupportedOperationException();
    }

    public void alterarNomePessoa(String cpf, String novoNome) {

    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {

    }

    public void removerPessoa(String cpf) {

    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {

    }

    public String listarComentariosPessoa(String cpf) {
        throw new UnsupportedOperationException();
    }

    // ATIVIDADE
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        throw new UnsupportedOperationException();
    }

    public void encerrarAtividade(String atividadeId) {

    }

    public void desativarAtividade(String atividadeId) {

    }

    public void reabrirAtividade(String atividadeId) {

    }

    public String exibirAtividade(String atividadeId) {
        throw new UnsupportedOperationException();
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {

    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {

    }

    // TAREFA
    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
        throw new UnsupportedOperationException();
    }

    public void alterarNomeTarefa(String idTarefa, String novoNome) {

    }

    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {

    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {

    }

    public void removerHorasTarefa(String idTarefa, int horas) {

    }

    public void concluirTarefa(String idTarefa) {

    }

    public void removerTarefa(String idTarefa) {

    }

    public String exibirTarefa(String idTarefa) {
        throw new UnsupportedOperationException();
    }

    public void associarPessoaTarefa(String cpf, String idTarefa) {

    }

    public void removerPessoaTarefa(String cpf, String idTarefa) {

    }

}
