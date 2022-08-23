package sapo.busca;

import sapo.pessoa.PessoaService;

public class BuscaPessoa extends Busca {

    public BuscaPessoa(PessoaService pessoaService, String consulta) {
        super(pessoaService.consultar(consulta.toLowerCase().split(" ")), "PESSOA");
    }

}
