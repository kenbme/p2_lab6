package sapo.busca;

import sapo.pessoa.PessoaService;

public class BuscaPessoa implements Busca {
    private final String[] resultado;

    public BuscaPessoa(PessoaService pessoaService, String[] dados) {
        resultado =  pessoaService.consultar(dados);
    }

    @Override
    public String[] exibir() {
        return resultado;
    }

}
