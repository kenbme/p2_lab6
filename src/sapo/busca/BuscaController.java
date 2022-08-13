package sapo.busca;

public class BuscaController {

    private final BuscaService buscaService;
    // TODO VALIDACOES

    public BuscaController(BuscaService buscaService) {
        this.buscaService = buscaService;
    }

    public String[] exibirPessoas(String consulta) {
        
    }


    public String[] buscarAtividade(String consulta) {
    }

    public String[] buscarTarefas(String nome) {
    }

    public String[] buscarTarefas(String idAtividade, String nome) {
    }

    public String[] sugerirTarefas(String cpf) {
    }

    public String[] buscasMaisRecentes(int nBuscas) {
    }

    public String[] exibirHistoricoBusca(int indexBusca) {
    }

}
