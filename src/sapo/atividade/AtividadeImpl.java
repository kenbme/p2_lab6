package sapo.atividade;

public class AtividadeImpl implements Atividade {

    private final String ID;
    private final String nome;
    private String descricao;
    private String cpfResponsavel;
    private boolean encerrada;
    private boolean ativada;

    public AtividadeImpl(String ID, String nome, String descricao, String cpfResponsavel) {
        this.ID = ID;
        this.nome = nome;
        this.descricao = descricao;
        this.cpfResponsavel = cpfResponsavel;
        this.encerrada = false;
        this.ativada = true;
    }

    // TODO Checar erros, verificações e outras especificidades
    @Override
    public void encerrar(){
        if(!encerrada) {
            encerrada = true;
        }
        throw new IllegalStateException("Atividade já encerrada.");
    }

    @Override
    public void desativar(){
        if (!encerrada){
            ativada = false;
        }
        throw new IllegalStateException("Atividade já está desativada.");
    }

    @Override
    public void reabrir(){
        if (!ativada){
            ativada = true;
        }
        throw new IllegalStateException("Atividade já está ativada.");
    }

    @Override
    public void alterarDescricao(String novaDescricao) { this.descricao = novaDescricao; }

    @Override
    public void alterarResponsavel(String cpfResponsavelNovo){ this.cpfResponsavel = cpfResponsavelNovo; }

    @Override
    public String getResponsavel(){
        return this.cpfResponsavel;
    }

    @Override
    public String getNome(){
        return this.nome;
    }

    @Override
    public String getDescricao(){
        return this.descricao;
    }

}
