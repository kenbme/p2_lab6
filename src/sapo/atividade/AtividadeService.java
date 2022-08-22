package sapo.atividade;

import sapo.pessoa.PessoaService;

import java.util.NoSuchElementException;
import java.util.Optional;

public class AtividadeService {

    private final AtividadeRepository atividadeRepository;
    private final PessoaService pessoaService;

    public AtividadeService(AtividadeRepository atividadeRepository, PessoaService pessoaService) {
        this.atividadeRepository = atividadeRepository;
        this.pessoaService = pessoaService;
    }

    public String cadastrarAtividade(String nome, String descricao, String cpf) {
        String nomePessoa = pessoaService.getNomePessoaOuFalha(cpf);
        char[] arrayID = {'X', 'X', 'X'};
        int i = 0;
        for (char c : nome.toUpperCase().toCharArray()) {
            if (i == arrayID.length) {
                break;
            }
            if (c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U' && c != ' ') {
                arrayID[i] = c;
                i++;
            }
        }
        String ID = String.valueOf(arrayID) + "-" + atividadeRepository.totalAtividades();
        atividadeRepository.put(new AtividadeImpl(ID, nome, descricao, cpf, nomePessoa));
        return ID;
    }

    public void encerrarAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()) {
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().encerrar();
    }

    public void desativarAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()) {
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().desativar();
    }

    public void reabrirAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()) {
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().reabrir();
    }

    public String exibirAtividade(String id) throws NoSuchElementException {
        return atividadeRepository.get(id).orElseThrow().exibir();
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()) {
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().alterarDescricao(descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        Atividade atividade = atividadeRepository.get(atividadeId).orElseThrow();
        atividade.alterarResponsavel(cpf, pessoaService.getNomePessoaOuFalha(cpf));
    }

    public String[] consultar(String[] dados) {
        throw new UnsupportedOperationException();
    }

    public void adicionaTarefa(String atividadeID, String tarefaID, String tarefaNome) throws NoSuchElementException {
        Atividade atividade = atividadeRepository.get(atividadeID).orElseThrow();
        atividade.adicionaTarefa(tarefaID, tarefaNome);
    }

    public void removeTarefa(String atividadeID, String tarefaID) throws NoSuchElementException {
        Atividade atividade = atividadeRepository.get(atividadeID).orElseThrow();
        atividade.removeTarefa(tarefaID);
    }

    public void concluiTarefa(String atividadeID, String id) throws NoSuchElementException {
        Atividade atividade = atividadeRepository.get(atividadeID).orElseThrow();
        atividade.concluiTarefa(id);
    }

    public String getAtividadeNome(String atividadeID) throws NoSuchElementException {
        return atividadeRepository.get(atividadeID).orElseThrow().getNome();
    }
}
