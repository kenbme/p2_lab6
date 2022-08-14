package sapo.busca;

import sapo.atividade.AtividadeService;

public class BuscaAtividade implements Busca {

    private final String[] resultado;

    public BuscaAtividade(AtividadeService atividadeService, String[] dados) {
        resultado = atividadeService.consultar(dados);
    }

    @Override
    public String[] exibir() {
        return resultado;
    }

}
