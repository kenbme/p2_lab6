package sapo.tarefa;

import java.util.HashMap;

public class TarefaRepository {

    private HashMap<String ,Tarefa> tarefas = new HashMap<>();
    private int totalTarefas = 0;

    public String cadastraTarefa(String atividadeID, String nome, String[] habilidades) {
        this.totalTarefas ++;
        Tarefa tarefa = new Tarefa(atividadeID, Integer.toString(this.totalTarefas), nome, habilidades);
        this.tarefas.put(tarefa.getID(), tarefa);
        return tarefa.getID();
    }

    public void alteraNome(String IDTarefa, String novoNome) {
    	this.tarefas.get(IDTarefa).alteraNome(novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[] habilidades) {
    	this.tarefas.get(IDTarefa).alteraHabilidades(habilidades);
    }

    public void acrescentaHoras(String IDTarefa, int horas) {
    	this.tarefas.get(IDTarefa).acrescentaHoras(horas);
    }

    public void decrescentaHoras(String IDTarefa, int horas) {
    	this.tarefas.get(IDTarefa).decrescentaHoras(horas);
    }

    public void concluiTarefa(String IDTarefa) {
    	this.tarefas.get(IDTarefa).concluirTarefa();
    }

    public void removeTarefa(String IDTarefa) {
    	this.tarefas.remove(IDTarefa);
    }

    public String exibeTarefa(String IDTarefa) {
    	return this.tarefas.get(IDTarefa).toString();
    }

    public void adicionaPessoa(String IDTarefa, String CPF, String nome) {
    	this.tarefas.get(IDTarefa).adicionaPessoa(CPF, nome);
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	this.tarefas.get(IDTarefa).removePessoa(CPF);
    }
    
    public boolean concluida(String IDTarefa) {
    	return this.tarefas.get(IDTarefa).concluida();
    }

}