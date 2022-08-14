package sapo.busca;

import sapo.tarefa.TarefaService;

public class BuscaTarefa implements Busca {

    private final String[] resultado;

    public BuscaTarefa(TarefaService tarefaService, String idAtividade, String nome) {
        resultado = tarefaService.consultar(idAtividade, nome);
    }

    @Override
    public String[] exibir() {
        return resultado;
    }
    
}
