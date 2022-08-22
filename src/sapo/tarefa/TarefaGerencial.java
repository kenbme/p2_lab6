package sapo.tarefa;

import java.util.HashMap;
import java.util.Map;

public class TarefaGerencial extends Tarefa {

    private final HashMap<String, String> tarefas;

    public TarefaGerencial(String atividadeID, String atividadeNome, String tarefaID, String nome, String[] habilidades, HashMap<String, String> tarefas){
        super(atividadeID, atividadeNome, tarefaID, nome, habilidades);
        this.tarefas = tarefas;
    }

    public void adicionarTarefa(String idTarefa, String nomeTarefa){
        tarefas.put(idTarefa, nomeTarefa);
    }

    public void removerTarefa(String idTarefa){
        tarefas.remove(idTarefa);
    }

    public int contarTarefas(){
        return tarefas.size();
    }

    @Override
    public String toString() {
        String exibicao = super.toString() + "\n===\nTarefas:";
        for (Map.Entry<String, String> tarefa : tarefas.entrySet()) {
            exibicao += "\n- " + tarefa.getValue() + " - " + tarefa.getKey();
        }
        return exibicao;
    }

}
