package sapo.atividade;

public interface Atividade {

    void encerrar();
    void desativar();
    void reabrir();
    void alterarDescricao(String descricao);
    void alterarResponsavel(String cpfResponsavelNovo, String nomeResponsavelNovo);
    void adicionaTarefa(String tarefaID, String tarefaNome);
    void removeTarefa(String tarefaID);
    void concluiTarefa(String tarefaID);
    String exibir();

}