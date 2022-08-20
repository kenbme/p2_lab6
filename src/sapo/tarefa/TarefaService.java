package sapo.tarefa;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class TarefaService {

    private final TarefaRepository tr;
    private final PessoaService ps;
    private final AtividadeService as;


    public TarefaService(TarefaRepository tr, PessoaService ps, AtividadeService as) {
        this.tr = tr;
    	this.ps = ps;
        this.as = as;
    }
    
    public String cadastraTarefa(String atividadeID, String nome, String[] habilidades) {
    	Tarefa tarefa = new Tarefa(atividadeID,atividadeID + "-" + tr.getTotalTarefas(), nome, habilidades);
        this.as.adicionaTarefa(atividadeID, tarefa.getID(), nome);
        this.tr.put(tarefa);
    	return tarefa.getID();
    }

    public String cadastraTarefa(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
        HashMap<String, String> tarefas = new HashMap<>();
        for (String id: idTarefas) {
            tarefas.put(id, tr.get(id).orElseThrow().getNome());
        }
        TarefaGerencial tarefa = new TarefaGerencial(atividadeId,atividadeId + "-" + tr.getTotalTarefas(), nome, habilidades, tarefas);
        this.as.adicionaTarefa(atividadeId, tarefa.getID(), nome);
        this.tr.put(tarefa);
        return tarefa.getID();
    }

    public void alteraNome(String IDTarefa, String novoNome) {
        // TODO ALTERAR NOME AS SERVICE
    	this.tr.get(IDTarefa).orElseThrow().alteraNome(novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[]habilidades) {
    	this.tr.get(IDTarefa).orElseThrow().alteraHabilidades(habilidades);
    }

    public void acrescentaHoras(String IDTarefa, int horas) {
    	if (this.tr.get(IDTarefa).orElseThrow().concluida()) {
    		return;
    	}
    	this.tr.get(IDTarefa).orElseThrow().acrescentaHoras(horas);
    }

    public void decrescentaHoras(String IDTarefa, int horas) {
    	if (this.tr.get(IDTarefa).orElseThrow().concluida()) {
    		return;
    	}
    	this.tr.get(IDTarefa).orElseThrow().decrescentaHoras(horas);
    }

    public void concluiTarefa(String IDTarefa) {
        Tarefa tarefa = this.tr.get(IDTarefa).orElseThrow();
    	if(tarefa.concluirTarefa()) {
            as.concluiTarefa(tarefa.getAtividadeID(), tarefa.getID());
        }
    }

    public void removeTarefa(String IDTarefa) {
        Tarefa tarefa = this.tr.get(IDTarefa).orElseThrow();
        this.as.removeTarefa(tarefa.getAtividadeID(), tarefa.getID());
    	this.tr.remove(IDTarefa);
    }

    public String exibeTarefa(String IDTarefa) {
    	return this.tr.get(IDTarefa).orElseThrow().toString();
    }

    public void adicionaPessoa(String IDTarefa, String CPF) {
    	if (this.tr.get(IDTarefa).orElseThrow().concluida()) {
    		return;
    	}
    	String nome = this.ps.getNomePessoaOuFalha(CPF);
    	boolean concluida = this.tr.get(IDTarefa).get().concluida();
    	this.ps.contabilizaTarefa(CPF, concluida);
    	this.tr.get(IDTarefa).get().adicionaPessoa(CPF, nome);
    	this.tr.get(IDTarefa).orElseThrow().adicionaPessoa(CPF, nome);
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	if (this.tr.get(IDTarefa).orElseThrow().concluida()) {
    		return;
    	}
    	this.tr.get(IDTarefa).orElseThrow().removePessoa(CPF);
    }
    
    public boolean concluida (String IDTarefa) {
    	return this.tr.get(IDTarefa).orElseThrow().concluida();
    }

    public String[] consultar(String idAtividade, String nome) {
        throw new UnsupportedOperationException();
    }

    public String[] sugestionar(String cpf) {
        throw new UnsupportedOperationException();
    }

    public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        Tarefa tarefa = tr.get(idTarefaGerencial).orElseThrow();
        if (tarefa instanceof TarefaGerencial) {
            ((TarefaGerencial) tarefa).adicionarTarefa(idTarefa, tr.get(idTarefa).orElseThrow().getNome());
        }
    }

    public void removerDaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        Tarefa tarefa = tr.get(idTarefaGerencial).orElseThrow();
        if (tarefa instanceof TarefaGerencial) {
            ((TarefaGerencial) tarefa).removerTarefa(idTarefa);
        }
    }

    public int contarTodasTarefasNaTarefaGerencial(String idTarefaGerencial) {
        Tarefa tarefa = tr.get(idTarefaGerencial).orElseThrow();
        if (tarefa instanceof TarefaGerencial) {
            return ((TarefaGerencial) tarefa).contarTarefas();
        }
        throw new NoSuchElementException();
    }

}