package sapo;

import sapo.atividade.AtividadeRepository;
import sapo.busca.BuscaController;
import sapo.busca.BuscaService;
import sapo.pessoa.PessoaRepository;
import sapo.tarefa.TarefaController;
import sapo.tarefa.TarefaRepository;
import sapo.tarefa.TarefaService;
import sapo.pessoa.PessoaController;
import sapo.pessoa.PessoaService;
import sapo.atividade.AtividadeController;
import sapo.atividade.AtividadeService;

public class Facade {

    private final PessoaController pessoaController;
    private final AtividadeController atividadeController;
    private final TarefaController tarefaController;
    private final BuscaController buscaController;

    public Facade(PessoaRepository pessoaRepository, AtividadeRepository atividadeRepository,
                  TarefaRepository tarefaRepository) {
        PessoaService pessoaService = new PessoaService(pessoaRepository);
        AtividadeService atividadeService = new AtividadeService(atividadeRepository, pessoaService);
        TarefaService tarefaService = new TarefaService(tarefaRepository, pessoaService, atividadeService);
        BuscaService buscaService = new BuscaService(pessoaService, atividadeService, tarefaService);
        pessoaController = new PessoaController(pessoaService);
        atividadeController = new AtividadeController(atividadeService);
        tarefaController = new TarefaController(tarefaService);
        buscaController = new BuscaController(buscaService);
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
        return atividadeController.cadastrarAtividade(nome, descricao, cpf);
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
        return atividadeController.exibirAtividade(atividadeId);
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        atividadeController.alterarDescricaoAtividade(atividadeId, descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        atividadeController.alterarResponsavelAtividade(atividadeId, cpf);
    }

    // TAREFA
    public String cadastrarTarefa(String atividadeId, String nome, String[] habilidades) {
        return this.tarefaController.cadastraTarefa(atividadeId, nome, habilidades);
    }

    public void alterarNomeTarefa(String idTarefa, String novoNome) {
    	this.tarefaController.alteraNome(idTarefa, novoNome);
    }

    public void alterarHabilidadesTarefa(String idTarefa, String[] habilidades) {
        this.tarefaController.alteraHabilidade(idTarefa, habilidades);
    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {
    	this.tarefaController.acrescentaHoras(idTarefa, horas);
    }

    public void removerHorasTarefa(String idTarefa, int horas) {
    	this.tarefaController.decrescentaHoras(idTarefa, horas);
    }

    public void concluirTarefa(String idTarefa) {
    	this.tarefaController.concluiTarefa(idTarefa);
    }

    public void removerTarefa(String idTarefa) {
    	this.tarefaController.removeTarefa(idTarefa);
    }
    
    public boolean concluida (String idTarefa) {
    	return this.tarefaController.concluida(idTarefa);
    }

    public String exibirTarefa(String idTarefa) {
        return this.tarefaController.exibeTarefa(idTarefa);
    }

    public void associarPessoaTarefa(String cpf, String idTarefa) {
    	this.tarefaController.adicionaPessoa(idTarefa, cpf);
    }

    public void removerPessoaTarefa(String cpf, String idTarefa) {
    	this.tarefaController.removePessoa(idTarefa, cpf);
    }

    // BUSCA
    public String[] exibirPessoas(String consulta) {
        return buscaController.exibirPessoas(consulta);
    }

    public String[] buscarAtividade(String consulta) {
       return buscaController.buscarAtividade(consulta);
    }

    public String[] buscarTarefas(String nome) {
        return buscaController.buscarTarefas(nome);
    }

    public String[] buscarTarefas(String idAtividade, String nome) {
        return buscaController.buscarTarefas(idAtividade, nome);
    }

    public String[] sugerirTarefas(String cpf) {
        return buscaController.sugerirTarefas(cpf);
    }

    public String[] buscasMaisRecentes(int nBuscas) {
        return buscaController.buscasMaisRecentes(nBuscas);
    }

    public String[] exibirHistoricoBusca(int indexBusca) {
        return buscaController.exibirHistoricoBusca(indexBusca);
    }

    // FUNCAO
    public void cadastrarAluno(String cpf, String nome, String matr, int periodo, String[] habilidades) {

    }

    public void cadastrarProfessor(String cpf, String nome, String siape, String[] disciplinas, String[] habilidades) {

    }

    public void definirFuncaoProfessor(String cpf, String siape, String[] disciplinas) {

    }

    public void definirFuncaoAluno(String cpf, String matr, int periodo) {

    }

    public void removerFuncao(String cpf) {

    }

    public int pegarNivel(String cpf) {
        throw new UnsupportedOperationException();
    }

    public String[] listarPessoas() {
        throw new UnsupportedOperationException();
    }

    // TAREFA GERENCIAL
    public String cadastrarTarefaGerencial(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
        return tarefaController.cadastraTarefa(atividadeId, nome, habilidades, idTarefas);
    }

    public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        tarefaController.adicionarNaTarefaGerencial( idTarefaGerencial,  idTarefa);
    }

    public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        tarefaController.removerDaTarefaGerencial(idTarefaGerencial,  idTarefa);
    }

    public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
        return tarefaController.contarTodasTarefasNaTarefaGerencial(idTarefaGerencial);
    }

}
