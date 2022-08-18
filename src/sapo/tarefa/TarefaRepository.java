package sapo.tarefa;

import java.util.HashMap;

public class TarefaRepository {

    private HashMap<String ,Tarefa> tarefas = new HashMap<>();

    public void put(Tarefa tarefa) {
        this.tarefas.put(tarefa.getID(), tarefa);
    }

    public Tarefa get(String tarefaID) {
    	return this.tarefas.get(tarefaID);
    }

    public void remove(String IDTarefa) {
    	this.tarefas.remove(IDTarefa);
    }
    
}
