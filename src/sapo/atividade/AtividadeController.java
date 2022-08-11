package sapo.atividade;

public class AtividadeController {

    private final AtividadeService atividadeService;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
    }
    //TODO Implementar TUDO
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        return "vou fazer carai";
    }

    public void encerrarAtividade(String atividadeId) {

    }

    public void desativarAtividade(String atividadeId) {

    }

    public void reabrirAtividade(String atividadeId) {

    }

    public String exibirAtividade(String atividadeId) {
        return "vou fazer ainda intellij, fique calmo";
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {

    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {

    }
}
