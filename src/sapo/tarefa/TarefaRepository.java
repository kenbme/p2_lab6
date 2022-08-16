package sapo.tarefa;

public class TarefaRepository {

    private Map<String ,Tarefa> tarefas;
    private int totalTarefas = 0;

    public String cadastraTarefa(String atividadeID, String nome, Set<String> habilidades) {
        this.totalTarefas ++;
        String tarefaID = atividadeID + "-" + totalTarefas;
        Tarefa tarefa = new Tarefa();
    }

    public void alteraNome(String IDTarefa, String novoNome) {

    }

    public void alteraHabilidade(String IDTarefa, Set<String> habilidades) {

    }

    public void acrescentaHoras(String IDTarefas, int horas) {

    }

    public void decrescentaHoras(String IDTarefas, int horas) {

    }

    public void concluiTarefa(String IDTarefa) {

    }

    public void removeTarefa(String IDTarefa) {

    }

    public String exibeTarefa(String IDTarefa) {

    }

    public void adicionaPessoa(String IDTarefa, String CPF) {

    }

    public void remotePessoa(String IDTarefa, String CPF) {

    }

}