package sapo.atividade;

import sapo.pessoa.Pessoa;

public interface Atividade {

    void encerrar();
    void desativar();
    void reabrir();
    void alterarDescricao(String descricao);
    void alterarResponsavel(Pessoa novoResponsavel);
    Pessoa getResponsavel();

}