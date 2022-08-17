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
    	String ID = this.tr.cadastraTarefa(atividadeID, nome, habilidades);
    	return ID;
    }

    public void alteraNome(String IDTarefa, String novoNome) {
    	this.tr.alteraNome(IDTarefa, novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[]habilidades) {
    	this.tr.alteraHabilidade(IDTarefa, habilidades);
    }

    public void acrescentaHoras(String IDTarefas, int horas) {
    	this.tr.acrescentaHoras(IDTarefas, horas);
    }

    public void decrescentaHoras(String IDTarefas, int horas) {
    	this.tr.decrescentaHoras(IDTarefas, horas);
    }

    public void concluiTarefa(String IDTarefa) {
    	this.tr.concluiTarefa(IDTarefa);
    }

    public void removeTarefa(String IDTarefa) {
    	this.tr.removeTarefa(IDTarefa);
    }

    public String exibeTarefa(String IDTarefa) {
    	return this.tr.exibeTarefa(IDTarefa);
    }

    public void adicionaPessoa(String IDTarefa, String CPF) {
    	String nome = this.ps.getNomePessoa(CPF);
    	this.tr.adicionaPessoa(IDTarefa, CPF, nome);
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	this.tr.removePessoa(IDTarefa, CPF);
    }
    
    public boolean concluida (String IDTarefa) {
    	return this.tr.concluida(IDTarefa);
    }

    public String[] consultar(String idAtividade, String nome) {
        throw new UnsupportedOperationException();
    }

    public String[] sugestionar(String cpf) {
        throw new UnsupportedOperationException();
    }
}