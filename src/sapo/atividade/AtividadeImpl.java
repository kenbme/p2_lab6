package sapo.atividade;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AtividadeImpl implements Atividade {

    private final String id;
    private final String nome;
    private String responsavelCpf;
    private String responsavelNome;
    private String descricao;
    private boolean encerrada;
    private boolean ativada;
    private final HashMap<String, String> tarefas;
    private int totalTarefas;
    private int tarefasConcluidas;

    public AtividadeImpl(String id, String nome, String descricao, String responsavelCpf, String responsavelNome) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.encerrada = false;
        this.ativada = true;
        tarefas = new HashMap<>();
        this.responsavelCpf = responsavelCpf;
        this.responsavelNome = responsavelNome;
        totalTarefas = 0;
        tarefasConcluidas = 0;
    }

    // TODO Checar erros, verificações e outras especificidades
    @Override
    public void encerrar(){
        if(ativada && !encerrada && tarefasConcluidas == totalTarefas) {
            encerrada = true;
        } else { throw new IllegalStateException("Atividade já encerrada ou há tarefas pendentes.");}
    }

    @Override
    public void desativar(){
        if (!encerrada && tarefasConcluidas == totalTarefas){
            ativada = false;
        } else{ throw new IllegalStateException("Atividade já está desativada ou há tarefas pendentes."); }
    }

    @Override
    public void reabrir(){
        if (!ativada){
            ativada = true;
        } else{ throw new IllegalStateException("Atividade já está ativada."); }
    }

    @Override
    public void alterarDescricao(String novaDescricao) { this.descricao = novaDescricao; }

    @Override
    public void alterarResponsavel(String cpfResponsavelNovo, String nomeResponsavelNovo){
        this.responsavelCpf = cpfResponsavelNovo;
        this.responsavelNome = nomeResponsavelNovo;
    }

    @Override
    public void adicionaTarefa(String tarefaID, String tarefaNome) {
        if(ativada && !encerrada) {
            if (tarefas.containsKey(tarefaID)) {
                return;
            }
            tarefas.put(tarefaID, tarefaNome);
            totalTarefas++;
        } else{ throw new IllegalStateException("Atividade desativada/encerrada não pode receber novas tarefas."); }
    }

    @Override
    public void removeTarefa(String tarefaID) {
        tarefas.remove(tarefaID);
    }

    @Override
    public void concluiTarefa(String tarefaID) {
       if (tarefas.remove(tarefaID) != null) {
           tarefasConcluidas++;
       }
    }

    @Override
    public String exibir() {
        String exibicao = id + ": " + nome;
        if (responsavelCpf != null) {
            exibicao += "\nResponsável: " + responsavelNome + " – " + responsavelCpf;
        }
        exibicao += "\n===\n" + descricao + "\n===\n" + imprimeTarefas();
        return exibicao;
    }

    private String imprimeTarefas() {
        String exibicao = "Tarefas: " + tarefasConcluidas + "/" + totalTarefas;
        ArrayList<String> tarefas = new ArrayList<>();
        for (Map.Entry<String, String> tarefa : this.tarefas.entrySet()) {
            tarefas.add(tarefa.getValue() + " - " + tarefa.getKey());
        }
        if(!tarefas.isEmpty()) {
            for (int i = tarefas.size() - 1; i > -1; i--) {
                exibicao += "\n- " + tarefas.get(i);
            }
        }
        return exibicao;
    }

}
