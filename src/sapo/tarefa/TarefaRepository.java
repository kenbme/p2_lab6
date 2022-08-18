package sapo.tarefa;

import java.util.HashMap;
import java.util.Optional;

public class TarefaRepository {

    private HashMap<String ,Tarefa> tarefas = new HashMap<>();

    public void put(Tarefa tarefa) {
        this.tarefas.put(tarefa.getID(), tarefa);
    }

    public Optional<Tarefa> get(String tarefaID) {
    	return Optional.ofNullable(tarefas.get(tarefaID));
    }

    public void remove(String IDTarefa) {
    	this.tarefas.remove(IDTarefa);
    }
    
}
