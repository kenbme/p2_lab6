package sapo.tarefa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TarefaGerencial implements Tarefaw {
    private int horasExecutadas;
    private String nome;
    private String[] habilidadesRecomendadas;
    private HashSet<String> cpfs;
    private String ID;
    private boolean concluida;
    private HashSet<String> idTarefas;

    public TarefaGerencial(String ID, String nome, String[] habilidades, String[] idTarefas){
        this.nome = nome;
        this.habilidadesRecomendadas = habilidades;
        this.idTarefas = new HashSet<>();
        this.idTarefas.add("Gestão");
        this.idTarefas.addAll(Arrays.asList(idTarefas));
        this.ID = ID;
        this.concluida = false;
    }
    public HashSet<String> getIdTarefas(){
        return idTarefas;
    }

    @Override
    public void acrescentaHoras(int horas) {
        this.horasExecutadas += horas;
    }

    @Override
    public void decrescentaHoras(int horas) {
        this.horasExecutadas -= horas;
        if (this.horasExecutadas < 0) {
            this.horasExecutadas = 0;
        }
    }
    @Override
    public void adicionaPessoa(String CPF) {
        this.cpfs.add(CPF);
    }
    @Override
    public void removePessoa(String CPF) {
        this.cpfs.remove(CPF);
    }
    @Override
    public void concluirTarefa(){
        this.concluida = true;
    }
    public void adicionarTarefa(String idTarefa){
        this.idTarefas.add(idTarefa);
    }
    public void removerTarefa(String idTarefa){
        this.idTarefas.remove(idTarefa);
    }
    public int contarTarefas(){
        return this.idTarefas.size();
    }
}
