package sapo.atividade;

import sapo.Validador;

public class AtividadeController {

    private final AtividadeService atividadeService;
    private final Validador validador;

    public AtividadeController(AtividadeService atividadeService) {
        this.atividadeService = atividadeService;
        this.validador = new Validador();
    }

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        validador.validaCpf(cpf);
        validador.valida(nome);
        validador.valida(descricao);
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
        validador.validaCpf(cpf);
        atividadeService.alterarResponsavelAtividade(atividadeId, cpf);
    }

}
