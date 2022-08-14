package sapo.atividade;

public class AtividadeController {

    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }
    //TODO Implementar TUDO
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        // IMPLEMENTAR VALIDACAO DA ENTRADA
        return atividadeService.cadastrarAtividade(nome, descricao, cpf);
    }

    public void encerrarAtividade(String atividadeId) {
        atividadeService.encerrarAtividade(atividadeId);
    }

    public void desativarAtividade(String atividadeId) {
        atividadeService.desativarAtividade(atividadeId);
    }

    public void reabrirAtividade(String atividadeId) {
        atividadeService.reabrirAtividade(atividadeId);
    }

    public String exibirAtividade(String atividadeId) {
        return atividadeService.exibirAtividade(atividadeId);
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        atividadeService.alterarDescricaoAtividade(atividadeId, descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        atividadeService.alterarResponsavelAtividade(atividadeId, cpf);
    }
}
