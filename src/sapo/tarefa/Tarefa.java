package sapo.tarefa;

public class Tarefa {

    private int horasExecutadas;
    private String nome;
    private Set<String> habilidadesRecomendadas;
    private Set<String> pessoas;
    private final String ID;
    private boolean concluida;

    public Tarefa(String atividadeId, String numTarefa, String nome, Set<String> habilidades) {
        this.habilidadesRecomendadas = new Set<>();
        this.pessoas = new Set<>();
        this.nome = nome;
        this.habilidades = habilidades;
        this.ID = atividadeID + "-" + numTarefa;

        return this.ID;
    }

    public Tarefa(String atividadeId, String numTarefa, String nome, Set<String> habilidades, Set<String> CPF) {
        this.habilidadesRecomendadas = new Set<>();
        this.pessoas = new Set<>();
        this.nome = nome;
        this.habilidadesRecomendadas = habilidades;
        this.ID = atividadeID + "-" + numTarefa;
        this.pessoas = CPF;

        return this.ID;
    }

    public void alteraNome(String nome) {
        this.nome = nome;
    }

    public void alteraHabilidades(Set<String> habilidades) {
        this.habilidadesRecomendadas = habilidades;
    }

    public void acrescentaHoras(int horas) {
        this.horasExecutadas += horas;
    }

    public void decrescentaHoras(int horas) {
        this.horasExecutadas -= horas;
        if (this.horasExecutadas > 0) {
            this.horasExecutadas = 0;
        }
    }

    public String toString() {
        return this.nome + " " + this.ID + "\n" +
                    " (" + horasExecutadas + "hora(s) Executada(s)" + "\n" +
                    "===" + "\n" +
                    "Equipe:" + "\n" + 
                    equipes();
    }

    public void concluirTarefa() {
        if (this.concluida) {
            this.concluida = false;
        } else {
            this.concluida = true;
        }
    }

    public void adicionaPessoa(String CPF) {
        this.pessoas.add(CPF);
    }

    public void removePessoa(String CPF) {
        this.pessoas.remove(CPF);
    }

    private String equipes (){
        String equipes = "";
        int i = 1
        for (String pessoa : this.pessoas) {
            String equipe = "equipe" + i + " - " + pessoa;
            equipes += equipe + "\n";
            i ++;
        }
        
        return equipes;
    }

}