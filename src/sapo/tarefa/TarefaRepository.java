package sapo.tarefa;

import java.util.HashMap;
import java.util.Optional;

public class TarefaRepository {

    private HashMap<String ,Tarefa> tarefas = new HashMap<>();
    private int totalTarefas = 0;

    public void put(Tarefa tarefa) {
        this.tarefas.put(tarefa.getID(), tarefa);
        this.totalTarefas++;
    }

    public Optional<Tarefa> get(String tarefaID) {
    	return Optional.ofNullable(tarefas.get(tarefaID));
    }

    public void remove(String IDTarefa) {
    	this.tarefas.remove(IDTarefa);
    }

    public int getTotalTarefas() {
        return totalTarefas;
    }

}
