package sapo.busca;

public class BuscaController {

    private final BuscaService buscaService;
    // TODO VALIDACOES

    public BuscaController(BuscaService buscaService) {
        this.buscaService = buscaService;
    }

    public String[] exibirPessoas(String consulta) {
        return buscaService.exibirPessoas(consulta);
    }

    public String[] buscarAtividade(String consulta) {
        return buscaService.buscarAtividade(consulta);
    }

    public String[] buscarTarefas(String nome) {
        return buscaService.buscarTarefas(null, nome);
    }

    public String[] buscarTarefas(String idAtividade, String nome) {
        return buscaService.buscarTarefas(idAtividade, nome);
    }

    public String[] sugerirTarefas(String cpf) {
        return buscaService.sugerirTarefas(cpf);
    }

    public String[] buscasMaisRecentes(int nBuscas) {
        return buscaService.buscasMaisRecentes(nBuscas);
    }

    public String[] exibirHistoricoBusca(int indexBusca) {
        return buscaService.exibirHistoricoBusca(indexBusca);
    }

}
