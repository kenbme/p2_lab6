package sapo.busca;

import sapo.Validador;

public class BuscaController {

    private final BuscaService buscaService;
    private final Validador validador;

    public BuscaController(BuscaService buscaService) {
        this.buscaService = buscaService;
        this.validador = new Validador();
    }

    public String[] exibirPessoas(String consulta) {
        validador.valida(consulta);
        return buscaService.exibirPessoas(consulta);
    }

    public String[] buscarAtividade(String consulta) {
        validador.valida(consulta);
        return buscaService.buscarAtividade(consulta);
    }

    public String[] buscarTarefas(String nome) {
        validador.valida(nome);
        return buscaService.buscarTarefas(null, nome);
    }

    public String[] buscarTarefas(String idAtividade, String nome) {
        validador.valida(idAtividade);
        validador.valida(nome);
        return buscaService.buscarTarefas(idAtividade, nome);
    }

    public String[] sugerirTarefas(String cpf) {
        validador.valida(cpf);
        return buscaService.sugerirTarefas(cpf);
    }

    public String[] buscasMaisRecentes(int nBuscas) {
        validador.valida(nBuscas);
        return buscaService.buscasMaisRecentes(nBuscas);
    }

    public String[] exibirHistoricoBusca(int indexBusca) {
        validador.valida(indexBusca);
        return buscaService.exibirHistoricoBusca(indexBusca);
    }

}
