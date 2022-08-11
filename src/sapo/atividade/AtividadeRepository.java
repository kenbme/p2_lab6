package sapo.atividade;

import java.util.HashMap;

public class AtividadeRepository {

    HashMap<String, Atividade> atividades;
    int atividadeNum = 0;
    String atividadeSigla;

    public AtividadeRepository() {
        atividades = new HashMap<>();
    }

    // TODO Implementar métodos que faltam
    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        atividadeNum ++;
        atividadeSigla = "XXX";
        String atividadeID = atividadeSigla + atividadeNum;
        return atividadeID;
    }

    public void encerrarAtividade(String atividadeId) {

    }

    public void desativarAtividade(String atividadeId) {

    }

    public void reabrirAtividade(String atividadeId) {

    }

    public Atividade exibirAtividade(String atividadeId) {
        return atividades.get(atividadeId);
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {

    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {

    }

}
