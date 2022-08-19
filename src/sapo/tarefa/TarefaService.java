package sapo.tarefa;

import sapo.pessoa.PessoaService;

public class TarefaService {

    private final TarefaRepository tr;
    private final PessoaService ps;


    public TarefaService(TarefaRepository tr, PessoaService ps) {
        this.tr = tr;
    	this.ps = ps;
    }
    
    public String cadastraTarefa(String atividadeID, String nome, String[] habilidades) {
    	Tarefa tarefa = new Tarefa(atividadeID, Integer.toString(tr.getTotalTarefas()), nome, habilidades);
    	this.tr.put(tarefa);
    	return tarefa.getID();
    }

    public void alteraNome(String IDTarefa, String novoNome) {
    	this.tr.get(IDTarefa).get().alteraNome(novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[]habilidades) {
    	this.tr.get(IDTarefa).get().alteraHabilidades(habilidades);
    }

    public void acrescentaHoras(String IDTarefa, int horas) {
    	if (this.tr.get(IDTarefa).get().concluida()) {
    		return;
    	}
    	this.tr.get(IDTarefa).get().acrescentaHoras(horas);
    }

    public void decrescentaHoras(String IDTarefa, int horas) {
    	if (this.tr.get(IDTarefa).get().concluida()) {
    		return;
    	}
    	this.tr.get(IDTarefa).get().decrescentaHoras(horas);
    }

    public void concluiTarefa(String IDTarefa) {
    	this.tr.get(IDTarefa).get().concluirTarefa();
    }

    public void removeTarefa(String IDTarefa) {
    	this.tr.remove(IDTarefa);
    }

    public String exibeTarefa(String IDTarefa) {
    	return this.tr.get(IDTarefa).get().toString();
    }

    public void adicionaPessoa(String IDTarefa, String CPF) {
    	if (this.tr.get(IDTarefa).get().concluida()) {
    		return;
    	}
    	String nome = this.ps.getNomePessoaOuFalha(CPF);
    	this.tr.get(IDTarefa).get().adicionaPessoa(CPF, nome);
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	if (this.tr.get(IDTarefa).get().concluida()) {
    		return;
    	}
    	this.tr.get(IDTarefa).get().removePessoa(CPF);
    }
    
    public boolean concluida (String IDTarefa) {
    	return this.tr.get(IDTarefa).get().concluida();
    }

    public String[] consultar(String idAtividade, String nome) {
        throw new UnsupportedOperationException();
    }

    public String[] sugestionar(String cpf) {
        throw new UnsupportedOperationException();
    }
    
}