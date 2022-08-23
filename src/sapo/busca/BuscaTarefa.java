package sapo.busca;

import sapo.tarefa.TarefaService;


public class BuscaTarefa extends Busca {

    public BuscaTarefa(TarefaService tarefaService, String nome) {
        super(tarefaService.consultar(nome.toLowerCase()), "TAREFA");
    }

    public BuscaTarefa(TarefaService tarefaService, String idAtividade, String nome) {
        super(tarefaService.consultar(idAtividade, nome.toLowerCase()), "TAREFA");
    }
    
}
