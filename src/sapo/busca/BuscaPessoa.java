package sapo.busca;

public class BuscaPessoa implements Busca {

    private final String[] dados;
    private String[] resultado;

    public BuscaPessoa(String[] dados) {
        this.dados = dados;
    }

    public void consultar(Consultavel servico) {
        resultado = servico.consultar(dados);
    }

    @Override
    public String[] exibir() {
        return resultado;
    }

}
