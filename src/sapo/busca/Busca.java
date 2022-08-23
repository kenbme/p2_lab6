package sapo.busca;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Busca {

    private final String[] resultado;
    private final String tipo;

    public Busca(String[] resultado, String tipo) {
        this.resultado = resultado;
        this.tipo = tipo;
    }

    public String[] exibir() {
        return resultado;
    }

    public String[] exibirComDetalhes() {
        ArrayList<String> exibicao = new ArrayList<>();
        exibicao.add(tipo);
        exibicao.addAll(Arrays.asList(resultado));
        return exibicao.toArray(new String[0]);
    }

}
