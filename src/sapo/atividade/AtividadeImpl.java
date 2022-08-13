package sapo.atividade;

import sapo.pessoa.Pessoa;

public class AtividadeImpl implements Atividade {

    private final String ID;
    private final String nome;
    private String descricao;
    private Pessoa responsavel;
    private boolean encerrada = false;
    private boolean ativada = true;

    public AtividadeImpl(String ID, String nome, String descricao, Pessoa responsavel) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.responsavel = responsavel;
    }
    // TODO Checar erros, verificações e outras especificidades
    @Override
    public void encerrar(){
        if(encerrada != true){
            encerrada = true;
        }
        else {throw new IllegalStateException("Atividade já encerrada.");}
    }

    @Override
    public void desativar(){
        if (encerrada != true){
            ativada = false;
        }
    }

    @Override
    public void reabrir(){
        if (ativada != false){
            ativada = true;
        }
        else {throw new IllegalStateException("Atividade já está ativada.");}
    }

    @Override
    public void alterarDescricao(String novaDescricao) { descricao = novaDescricao; }

    @Override
    public void alterarResponsavel(Pessoa responsavelNovo){ this.responsavel = responsavelNovo; }
    @Override
    public Pessoa getResponsavel(){
        return this.responsavel;
    }

}
