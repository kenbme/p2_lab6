package sapo.tarefa;

import java.util.Optional;

import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaService;

public class TarefaService {

    private final TarefaRepository tr;
    private final PessoaService ps;
    private int totalTarefas = 1;

    public TarefaService(TarefaRepository tr, PessoaService ps) {
        this.tr = tr;
    	this.ps = ps;
    }
    
    public String cadastraTarefa(String atividadeID, String nome, String[] habilidades) {
    	Tarefa tarefa = new Tarefa(atividadeID, Integer.toString(this.totalTarefas), nome, habilidades);
    	this.totalTarefas ++;
    	this.tr.put(tarefa);
    	return tarefa.getID();
    }

    public void alteraNome(String IDTarefa, String novoNome) {
    	this.tr.get(IDTarefa).alteraNome(novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[]habilidades) {
    	this.tr.get(IDTarefa).alteraHabilidades(habilidades);
    }

    public void acrescentaHoras(String IDTarefa, int horas) {
    	this.tr.get(IDTarefa).acrescentaHoras(horas);
    }

    public void decrescentaHoras(String IDTarefa, int horas) {
    	this.tr.get(IDTarefa).decrescentaHoras(horas);
    }

    public void concluiTarefa(String IDTarefa) {
    	this.tr.get(IDTarefa).concluirTarefa();
    }

    public void removeTarefa(String IDTarefa) {
    	this.tr.remove(IDTarefa);
    }

    public String exibeTarefa(String IDTarefa) {
    	return this.tr.get(IDTarefa).toString();
    }

    public void adicionaPessoa(String IDTarefa, String CPF) {
    	String nome = this.ps.getPessoa(CPF).get().getNome();
    	this.tr.get(IDTarefa).adicionaPessoa(CPF, nome);;
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	this.tr.get(IDTarefa).removePessoa(CPF);
    }
    
    public boolean concluida (String IDTarefa) {
    	return this.tr.get(IDTarefa).concluida();
    }

    public String[] consultar(String idAtividade, String nome) {
        throw new UnsupportedOperationException();
    }

    public String[] sugestionar(String cpf) {
        throw new UnsupportedOperationException();
    }
}