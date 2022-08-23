package sapo.tarefa;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class TarefaGerencial extends Tarefa {

    private final LinkedHashMap<String, String> tarefas;

    public TarefaGerencial(String atividadeID, String atividadeNome, String tarefaID, String nome, String[] habilidades, LinkedHashMap<String, String> tarefas){
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
        String[] nomeTarefas = tarefas.values().toArray(new String[0]);
        String[] idTarefas = tarefas.keySet().toArray(new String[0]);
        for (int i = nomeTarefas.length - 1; i > -1; i--) {
            exibicao += "\n- " + nomeTarefas[i] + " - " + idTarefas[i];
        }
        return exibicao;
    }

    public String[] getIdTarefasSubordinadas(){
        ArrayList<String> idsTarefas = new ArrayList<String>();
        idsTarefas.addAll(tarefas.keySet());
        return idsTarefas.toArray(new String[0]);
    }
    public boolean contains(String idTarefaGerencial) {
        return tarefas.containsKey(idTarefaGerencial);
    }

}
