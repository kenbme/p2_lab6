package sapo.busca;

import sapo.atividade.AtividadeService;

public class BuscaAtividade extends Busca {

    public BuscaAtividade(AtividadeService atividadeService, String consulta) {
        super(atividadeService.consultar(consulta.toLowerCase().split(" ")), "ATIVIDADE");
    }

}
