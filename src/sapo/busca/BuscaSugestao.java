package sapo.busca;

import sapo.tarefa.TarefaService;

public class BuscaSugestao implements Busca {

    private final String[] resultado;

    public BuscaSugestao(TarefaService tarefaService, String cpf) {
        resultado = tarefaService.sugestionar(cpf);
    }

    @Override
    public String[] exibir() {
        return resultado;
    }

}
