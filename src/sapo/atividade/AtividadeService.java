package sapo.atividade;

import sapo.pessoa.Pessoa;
import sapo.pessoa.PessoaService;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;

public class AtividadeService {

    private final AtividadeRepository atividadeRepository;
    private final PessoaService pessoaService;

    public AtividadeService (PessoaService pessoaService){
        atividadeRepository = new AtividadeRepository();
        this.pessoaService = pessoaService;
    }
    public String cadastrarAtividade(String nome, String descricao, String cpf) throws NoSuchElementException {
        Optional<Pessoa> responsavel = pessoaService.getPessoa(cpf);
        if (responsavel.isEmpty()){
            throw new NoSuchElementException("CPF não cadastrado.");
        }
        String[] arrayID = {"X", "X", "X"};
        for(String c: (nome.toUpperCase()).split("")){
            for(int i = 0; i < 3; i++) {
                if (!c.equals("A") && !c.equals("E") && !c.equals("I") && !c.equals("O") && !c.equals("U") && !c.equals(" ")) {
                    arrayID[i] = c;
                }
            }
        }

        String ID = Arrays.toString(arrayID) + "-" + (atividadeRepository.totalAtividades());
        atividadeRepository.put(new AtividadeImpl(ID, nome, descricao, responsavel.get()));
        return ID;
    }

    public void encerrarAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if(atividade.isEmpty()){
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().encerrar();
    }

    public void desativarAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if(atividade.isEmpty()){
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().desativar();
    }

    public void reabrirAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if(atividade.isEmpty()){
            throw new NoSuchElementException("Atividade não existe");
        }
        atividade.get().reabrir();
    }

    public String exibirAtividade(String atividadeId) throws NoSuchElementException {
        Optional<Atividade> atividade = atividadeRepository.get(atividadeId);
        if (atividade.isEmpty()){
            throw new NoSuchElementException();
        }
        String saidaAtividade =
                atividadeId + ": " + atividade.getNome() + "\n" +
                "Responsável: " + atividade.getResponsavel();
    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {

    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {

    }


}
