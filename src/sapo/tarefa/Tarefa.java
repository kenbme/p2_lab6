package sapo.tarefa;

import java.util.HashMap;

public class Tarefa {

    private final String atividadeID;
    private int horasExecutadas;
    private String nome;
    private String[] habilidadesRecomendadas;
    private final HashMap<String, String> pessoas;
    private final String ID;
    private boolean concluida = false;

    public Tarefa(String atividadeID, String tarefaID, String nome, String[] habilidades) {
        this.pessoas = new HashMap<>();
        this.nome = nome;
        this.habilidadesRecomendadas = habilidades;
        this.ID = tarefaID;
        this.atividadeID = atividadeID;
    }

    public String getNome() {
        return nome;
    }

    public void alteraNome(String nome) {
        this.nome = nome;
    }

    public void alteraHabilidades(String[] habilidades) {
        this.habilidadesRecomendadas = habilidades;
    }

    public void acrescentaHoras(int horas) {
        this.horasExecutadas += horas;
    }

    public void decrescentaHoras(int horas) {
        this.horasExecutadas -= horas;
        if (this.horasExecutadas < 0) {
            this.horasExecutadas = 0;
        }
    }

    public String toString() {
        String exibicao = this.nome + " – " + this.ID;
        for (String habilidade : habilidadesRecomendadas) {
            exibicao += "\n- " + habilidade;
        }
        exibicao += "\n(" + this.horasExecutadas + " hora(s) executada(s)" + "\n===\n" + equipes();
        return exibicao;
    }

    public boolean concluirTarefa() {
        this.concluida = !this.concluida;
        return this.concluida;
    }

    public void adicionaPessoa(String CPF, String nome) {
        this.pessoas.put(CPF, nome);
    }


    public void removePessoa(String CPF) {
        this.pessoas.remove(CPF);
    }

    public String getID() {
        return this.ID;
    }

    public boolean concluida() {
        return this.concluida;
    }

    private String equipes() {
        String equipes = "Equipe:";
        for (String CPF : this.pessoas.keySet()) {
            equipes += "\n" + pessoas.get(CPF) + " - " + CPF;
        }

        return equipes;
    }

    public String getAtividadeID() {
        return atividadeID;
    }
    
    public String[] getHabilidadesRecomendadas() {
    	return this.habilidadesRecomendadas;
    }
    
    public HashMap<String, String> getPessoas(){
    	return this.pessoas;
    }

}