package sapo.tarefa;

public class TarefaController {

    private TarefaService ts;

    public TarefaController(TarefaService tarefaService) {
		this.ts = tarefaService;
	}

	public String cadastraTarefa(String atividadeID, String nome, String[] habilidades) {
    	String ID = this.ts.cadastraTarefa(atividadeID, nome, habilidades);
    	return ID;
    }

    public void alteraNome(String IDTarefa, String novoNome) {
    	this.ts.alteraNome(IDTarefa, novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[] habilidades) {
    	this.ts.alteraHabilidade(IDTarefa, habilidades);
    }

    public void acrescentaHoras(String IDTarefas, int horas) {
    	this.ts.acrescentaHoras(IDTarefas, horas);
    }

    public void decrescentaHoras(String IDTarefas, int horas) {
    	this.ts.decrescentaHoras(IDTarefas, horas);
    }

    public void concluiTarefa(String IDTarefa) {
    	this.ts.concluiTarefa(IDTarefa);
    }

    public void removeTarefa(String IDTarefa) {
    	this.ts.removeTarefa(IDTarefa);
    }

    public String exibeTarefa(String IDTarefa) {
    	return this.ts.exibeTarefa(IDTarefa);
    }

    public void adicionaPessoa(String IDTarefa, String CPF) {
    	this.ts.adicionaPessoa(IDTarefa, CPF);
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	this.ts.removePessoa(IDTarefa, CPF);
    }
    
    public boolean concluida (String IDTarefa) {
    	return this.ts.concluida(IDTarefa);
    }

}