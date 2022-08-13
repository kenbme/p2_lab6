package sapo;

import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaService;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaService;
import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeService;

public class Facade {

    private final PessoaController pessoaController;
    private final AtividadeController atividadeController;
    private final TarefaController tarefaController;

    public Facade() {
        PessoaService pessoaService = new PessoaService();
        AtividadeService atividadeService = new AtividadeService(pessoaService);
        TarefaService tarefaService = new TarefaService();
        pessoaController = new PessoaController(pessoaService);
        atividadeController = new AtividadeController(atividadeService);
        tarefaController = new TarefaController(tarefaService);
    }

    // PESSOA
    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        pessoaController.cadastrarPessoa(cpf, nome, habilidades);
    }

    public String exibirPessoa(String cpf) {
        return pessoaController.exibirPessoa(cpf);
    }

    public void alterarNomePessoa(String cpf, String novoNome) {
        pessoaController.alterarNomePessoa(cpf, novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        pessoaController.alterarHabilidadesPessoa(cpf, novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        pessoaController.removerPessoa(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        pessoaController.adicionarComentarioPessoa(cpf, comentario, autorCpf);
    }

    public String listarComentariosPessoa(String cpf) {
        return pessoaController.listarComentariosPessoa(cpf);
    }

    // ATIVIDADE
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        atividadeController.cadastrarAtividade(nome, descricao, cpf);
    }

    public void encerrarAtividade(String atividadeId) {
        atividadeController.encerrarAtividade(atividadeId);
    }

    public void desativarAtividade(String atividadeId) {
        atividadeController.desativarAtividade(atividadeId);
    }

    public void reabrirAtividade(String atividadeId) {
        atividadeController.reabrirAtividade(atividadeId);
    }

    public String exibirAtividade(String atividadeId) {
        atividadeController.exibirAtividade(atividadeId);
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        atividadeController.alterarDescricaoAtividade(atividadeId, descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        atividadeController.alterarResponsavelAtividade(atividadeId, cpf);
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
