package sapo.busca;

import sapo.atividade.AtividadeService;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

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
        Busca busca =  new BuscaPessoa(pessoaService, consulta.split(" "));
        buscaRepository.put(busca);
        return busca.exibir();
    }

    public String[] buscarAtividade(String consulta) {
        Busca busca =  new BuscaAtividade(atividadeService, consulta.split(" "));
        buscaRepository.put(busca);
        return busca.exibir();
    }

    public String[] buscarTarefas(String idAtividade, String nome) {
        Busca busca =  new BuscaTarefa(tarefaService, idAtividade, nome);
        buscaRepository.put(busca);
        return busca.exibir();
    }

    public String[] sugerirTarefas(String cpf) {
        Busca busca = new BuscaSugestao(tarefaService, cpf);
        buscaRepository.put(busca);
        return busca.exibir();
    }

    public String[] buscasMaisRecentes(int nBuscas) {
        ArrayList<String> buscas = new ArrayList<>();
        for (int i = buscaRepository.totalBuscas(); i > -1; i--) {
            if (nBuscas == buscaRepository.totalBuscas() - i) {
                break;
            }
            Optional<Busca> busca = buscaRepository.get(i - 1);
            if (busca.isEmpty()) {
                continue;
            }
            buscas.add(Arrays.toString(busca.get().exibir()));
        }
        return buscas.toArray(new String[0]);
    }

    public String[] exibirHistoricoBusca(int indexBusca) {
        throw new UnsupportedOperationException();
    }

}
