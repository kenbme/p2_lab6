package sapo.tarefa;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;

import java.util.*;

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
        Tarefa tarefa = new Tarefa(atividadeID, as.getAtividadeNome(atividadeID), atividadeID + "-" + tr.getTotalTarefas(), nome, habilidades);
        this.as.adicionaTarefa(atividadeID, tarefa.getID(), nome);
        this.tr.put(tarefa);
    	return tarefa.getID();
    }

    public String cadastraTarefa(String atividadeId, String nome, String[] habilidades, String[] idTarefas) {
        LinkedHashMap<String, String> tarefas = new LinkedHashMap<>();
        ArrayList<String> habilidadesGestao = new ArrayList<>();
        habilidadesGestao.add("gestão");
        habilidadesGestao.addAll(List.of(habilidades));
        for (String id: idTarefas) {
            tarefas.put(id, tr.get(id).orElseThrow().getNome());
        }
        TarefaGerencial tarefa = new TarefaGerencial(atividadeId, as.getAtividadeNome(atividadeId),
                atividadeId + "-" + tr.getTotalTarefas(), nome, habilidadesGestao.toArray(new String[0]), tarefas);
        this.as.adicionaTarefa(atividadeId, tarefa.getID(), nome);
        this.tr.put(tarefa);
        return tarefa.getID();
    }

    public void alteraNome(String IDTarefa, String novoNome) {
        Tarefa tarefa = tr.get(IDTarefa).orElseThrow();
        as.alteraNomeTarefa(tarefa.getAtividadeID(), tarefa.getID(), novoNome);
    	tarefa.alteraNome(novoNome);
    }

    public void alteraHabilidade(String IDTarefa, String[]habilidades) {
    	this.tr.get(IDTarefa).orElseThrow().alteraHabilidades(habilidades);
    }

    public void acrescentaHoras(String IDTarefa, int horas) {
        Tarefa tarefa = this.tr.get(IDTarefa).orElseThrow();
        if (tarefa.concluida() && !(tarefa instanceof TarefaGerencial)) {
            throw new IllegalStateException("Não é possível alterar horas de uma tarefa concluída.");
        }
    	tarefa.acrescentaHoras(horas);
    }

    public void decrescentaHoras(String IDTarefa, int horas) {
        Tarefa tarefa = this.tr.get(IDTarefa).orElseThrow();
    	if (tarefa.concluida() && !(tarefa instanceof TarefaGerencial)) {
    		throw new IllegalStateException("Não é possível alterar horas de uma tarefa concluída.");
    	}
    	tarefa.decrescentaHoras(horas);
    }

    public void concluiTarefa(String IDTarefa) {
        Tarefa tarefa = this.tr.get(IDTarefa).orElseThrow();
        if(tarefa.concluida()){
            throw new IllegalStateException("Tarefa já concluída.");
        }
        if (tarefa instanceof TarefaGerencial && !tarefa.concluida()){
            String[] idsTarefas = ((TarefaGerencial) tarefa).getIdTarefasSubordinadas();
            tarefa.concluirTarefa();
            for(String id: idsTarefas){
                concluiTarefa(id);
            }
        }else {
            if (tarefa.concluirTarefa()) {
                as.concluiTarefa(tarefa.getAtividadeID(), tarefa.getID());
                this.ps.contabilizaTarefaFinalizada(getDTO(IDTarefa));
            } else {
                this.ps.removeTarefaFinalizada(getDTO(IDTarefa));
            }
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
    		throw new IllegalStateException("Não é possível associar pessoas a uma tarefa concluída.");
    	}
    	this.tr.get(IDTarefa).orElseThrow().adicionaPessoa(CPF, this.ps.getNomePessoaOuFalha(CPF));
    	this.ps.contabilizaTarefa(getDTO(IDTarefa), CPF);
    }

    public void removePessoa(String IDTarefa, String CPF) {
    	if (this.tr.get(IDTarefa).orElseThrow().concluida()) {
            throw new IllegalStateException("Não é possível desassociar pessoas a uma tarefa concluída.");
    	}
    	this.tr.get(IDTarefa).orElseThrow().removePessoa(CPF);
    	this.ps.removeTarefa(getDTO(IDTarefa), CPF);
    }
    
    public boolean concluida (String IDTarefa) {
    	return this.tr.get(IDTarefa).orElseThrow().concluida();
    }


    public String[] consultar(String nome) {
        Set<Tarefa> tarefas = tr.consultar(nome);
        String[] resultado = new String[tarefas.size()];
        int i = 0;
        for (Tarefa tarefa : tarefas) {
            resultado[i] = tarefa.toString();
            i++;
        }
        return resultado;
    }

    public String[] consultar(String idAtividade, String nome) {
        Set<Tarefa> tarefas = tr.consultar(as.getAtividadeTarefas(idAtividade), nome);
        String[] resultado = new String[tarefas.size()];
        int i = 0;
        for (Tarefa tarefa : tarefas) {
            resultado[i] = tarefa.toString();
            i++;
        }
        return resultado;
    }

    public String[] sugestionar(String cpf) {
        throw new UnsupportedOperationException();
    }

    public void adicionarNaTarefaGerencial(String idTarefaGerencial, String idTarefa) {
        Tarefa tarefaGerencial = tr.get(idTarefaGerencial).orElseThrow();
        if (!(tarefaGerencial instanceof TarefaGerencial)) {
            return;
        }
        Tarefa tarefa = tr.get(idTarefa).orElseThrow();
        if (tarefa instanceof TarefaGerencial) {
            if (((TarefaGerencial)tarefa).contains(idTarefaGerencial)) {
                throw new IllegalStateException("Ciclo detectado.");
            }
        }
        ((TarefaGerencial) tarefaGerencial).adicionarTarefa(idTarefa, tarefa.getNome());
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

    private TarefaDTO getDTO(String tarefaID) {
    	String[] habilidades = this.tr.get(tarefaID).orElseThrow().getHabilidadesRecomendadas();
    	HashMap<String, String> pessoas = this.tr.get(tarefaID).orElseThrow().getPessoas();
    	String ID = this.tr.get(tarefaID).orElseThrow().getID();
    	return new TarefaDTO(habilidades, pessoas, ID);
    }

}