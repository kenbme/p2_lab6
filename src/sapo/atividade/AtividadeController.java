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
        validador.valida(atividadeId);
        validador.validaID(atividadeId);
        atividadeService.encerrarAtividade(atividadeId);
    }

    public void desativarAtividade(String atividadeId) {
        validador.valida(atividadeId);
        validador.validaID(atividadeId);
        atividadeService.desativarAtividade(atividadeId);
    }

    public void reabrirAtividade(String atividadeId) {
        validador.valida(atividadeId);
        validador.validaID(atividadeId);
        atividadeService.reabrirAtividade(atividadeId);
    }

    public String exibirAtividade(String atividadeId) {
        validador.valida(atividadeId);
        validador.validaID(atividadeId);
        return atividadeService.exibirAtividade(atividadeId);
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        validador.valida(atividadeId);
        validador.validaID(atividadeId);
        validador.valida(descricao);
        atividadeService.alterarDescricaoAtividade(atividadeId, descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        validador.valida(atividadeId);
        validador.validaID(atividadeId);
        validador.validaCpf(cpf);
        atividadeService.alterarResponsavelAtividade(atividadeId, cpf);
    }

}
