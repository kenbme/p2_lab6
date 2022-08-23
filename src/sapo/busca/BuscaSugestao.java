package sapo.busca;

import sapo.tarefa.TarefaService;

public class BuscaSugestao extends Busca {

    public BuscaSugestao(TarefaService tarefaService, String cpf) {
        super(tarefaService.sugestionar(cpf), "SUGESTÃO");
    }

}
