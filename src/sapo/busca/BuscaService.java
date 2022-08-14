package sapo.busca;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaService;

import java.util.ArrayList;
import java.util.Arrays;

public class BuscaService {

    private final PessoaService pessoaService;
    private final AtividadeService atividadeService;
    private final TarefaService tarefaService;
    private final BuscaRepository buscaRepository;

    public BuscaService(PessoaService pessoaService, AtividadeService atividadeService, TarefaService tarefaService) {
        this.pessoaService = pessoaService;
        this.atividadeService = atividadeService;
        this.tarefaService = tarefaService;
        buscaRepository = new BuscaRepository();
    }

    public String[] exibirPessoas(String consulta) {
        Busca busca =  new BuscaPessoa(consulta.split(" "));
        busca.consultar(pessoaService);
        buscaRepository.put(busca);
        return busca.exibir();
    }

    public String[] buscarAtividade(String consulta) {
        throw new UnsupportedOperationException();
    }

    public String[] buscarTarefas(String idAtividade, String nome) {
        throw new UnsupportedOperationException();
    }

    public String[] sugerirTarefas(String cpf) {
        throw new UnsupportedOperationException();
    }



    public String[] buscasMaisRecentes(int nBuscas) {
        ArrayList<String> buscas = new ArrayList<>();
        for (int i = buscaRepository.totalBuscas(); i > -1; i--) {
            if (nBuscas == buscaRepository.totalBuscas() - i) {
                break;
            }
            buscas.add(Arrays.toString(buscaRepository.get(i - 1).get().exibir()));
        }
        return buscas.toArray(new String[0]);
    }

    public String[] exibirHistoricoBusca(int indexBusca) {
        throw new UnsupportedOperationException();
    }

}
