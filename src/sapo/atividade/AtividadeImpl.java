package sapo.atividade;

public class AtividadeImpl implements Atividade {

    private String nome;
    private String descricao;
    private String cpf;
    private boolean encerrada = false;
    private boolean ativada = true;

    public AtividadeImpl(String nome, String descricao, String cpf) {
        this.nome = nome;
        this.descricao = descricao;
        this.cpf = cpf;
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
    public void alterarResponsavel(String cpfNovo){ cpf = cpfNovo; }

}
