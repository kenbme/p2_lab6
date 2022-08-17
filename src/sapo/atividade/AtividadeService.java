package sapo.atividade;

import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaService;
import sapo.tarefa.TarefaService;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AtividadeService {

    private final AtividadeRepository atividadeRepository;
    private final PessoaService pessoaService;
    private final TarefaService tarefaService;

    public AtividadeService(AtividadeRepository atividadeRepository, PessoaService pessoaService, TarefaService tarefaService) {
        this.atividadeRepository = atividadeRepository;
        this.pessoaService = pessoaService;
        this.tarefaService = tarefaService;
    }

    public String cadastrarAtividade(String nome, String descricao, String cpf) throws NoSuchElementException {
        Optional<Pessoa> responsavel = pessoaService.getPessoa(cpf);
        if (responsavel.isEmpty()) {
            throw new NoSuchElementException("CPF não cadastrado.");
        }
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
        atividadeRepository.put(new AtividadeImpl(ID, nome, descricao, responsavel.get().getCPF()));
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

    public String exibirAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()){
            throw new NoSuchElementException("Atividade não existe");
        }
        String nomePessoa = pessoaService.getPessoa(atividade.get().getResponsavel()).get().getNome();
        String saidaAtividade =

                atividadeId + ": " + atividade.get().getNome() + "\n" +
                "Responsável: " + nomePessoa + " - " + atividade.get().getResponsavel() + "\n" +
                "===\n" +
                atividade.get().getDescricao() + "\n" +
                "===\n" +
                        Arrays.toString(tarefaService.consultar(atividadeId, nomePessoa));

        return saidaAtividade;
    }


    public void alterarDescricaoAtividade(String atividadeId, String descricao) {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()) {
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().alterarDescricao(descricao);
    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()) {
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().alterarResponsavel(cpf);
    }

    public String[] consultar(String[] dados) {
        throw new UnsupportedOperationException();
    }
}
