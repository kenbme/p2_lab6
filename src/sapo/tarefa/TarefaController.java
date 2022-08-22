package sapo.tarefa;

import sapo.Validador;

public class TarefaController {

    private final TarefaService ts;
    private final Validador validador;

    public TarefaController(TarefaService tarefaService) {
		this.ts = tarefaService;
		this.validador = new Validador();
	}

	public String cadastraTarefa(String atividadeID, String nome, String[] habilidades) {
		this.validador.valida(new String[]{atividadeID, nome});
		this.validador.valida(habilidades);
    	return this.ts.cadastraTarefa(atividadeID, nome, habilidades);
    }

    public void alteraNome(String IDTarefa, String novoNome) {
    	this.validador.valida(new String[] {IDTarefa, novoNome});
    	this.ts.alteraNome(IDTarefa, novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[] habilidades) {
    	this.validador.valida(IDTarefa);
    	this.validador.valida(habilidades);
    	this.ts.alteraHabilidade(IDTarefa, habilidades);
    }

    public void acrescentaHoras(String IDTarefa, int horas) {
    	this.validador.valida(IDTarefa);
    	this.validador.isPositivo(horas);
    	this.ts.acrescentaHoras(IDTarefa, horas);
    }

    public void decrescentaHoras(String IDTarefa, int horas) {
    	this.validador.valida(IDTarefa);
    	this.validador.isPositivo(horas);
    	this.ts.decrescentaHoras(IDTarefa, horas);
    }

    public void concluiTarefa(String IDTarefa) {
    	this.validador.valida(IDTarefa);
    	this.ts.concluiTarefa(IDTarefa);
    }

    public void removeTarefa(String IDTarefa) {
    	this.validador.valida(IDTarefa);
    	this.ts.removeTarefa(IDTarefa);
    }

    public String exibeTarefa(String IDTarefa) {
    	this.validador.valida(IDTarefa);
    	return this.ts.exibeTarefa(IDTarefa);
    }

    public void adicionaPessoa(String IDTarefa, String CPF) {
    	this.validador.valida(new String[] {IDTarefa, CPF});
		this.validador.validaCpf(CPF);
    	this.ts.adicionaPessoa(IDTarefa, CPF);
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	this.validador.valida(new String[] {IDTarefa, CPF});
		this.validador.validaCpf(CPF);
    	this.ts.removePessoa(IDTarefa, CPF);
    }
    
    public boolean concluida (String IDTarefa) {
    	this.validador.valida(IDTarefa);
    	return this.ts.concluida(IDTarefa);
    }

    public String cadastraTarefa(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
		return ts.cadastraTarefa(atividadeId, nome, habilidades, idTarefas);
	}

	public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
		ts.adicionarNaTarefaGerencial(idTarefaGerencial, idTarefa);
	}

	public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
		ts.removerDaTarefaGerencial(idTarefaGerencial, idTarefa);
	}

	public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
		return ts.contarTodasTarefasNaTarefaGerencial(idTarefaGerencial);
	}

    public String cadastrarTarefaGerencial(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
    	return ts.cadastraTarefa(atividadeId, nome, habilidades, idTarefas);
	}

}