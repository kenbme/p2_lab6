package sapo.tarefa;

import java.util.*;
import java.util.stream.Collectors;

public class TarefaRepository {

    private final HashMap<String ,Tarefa> tarefas = new HashMap<>();
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

    public Set<Tarefa> consultar(String nome) {
        return this.tarefas.values().stream()
                .filter(tarefa -> tarefa.getNome().toLowerCase().contains(nome)).sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public Set<Tarefa> consultar(String[] idTarefas, String nome) {
        Set<Tarefa> tarefas = new LinkedHashSet<>();
        Arrays.stream(idTarefas).forEach((idTarefa) -> {
            Tarefa tarefa = this.tarefas.get(idTarefa);
            if (tarefa != null) {
                if (tarefa.getNome().toLowerCase().contains(nome)) {
                    tarefas.add(tarefa);
                }
            }
        });
        return tarefas.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
