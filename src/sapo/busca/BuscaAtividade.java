package sapo.busca;

import sapo.atividade.AtividadeService;

public class BuscaAtividade implements Busca {
    private final String[] dados;
    private final String[] resultado;

    public BuscaAtividade(AtividadeService atividadeService, String[] dados) {
        this.dados = dados;
        resultado = atividadeService.consultar(dados);
    }

    @Override
    public String[] exibir() {
        return resultado;
    }

}
