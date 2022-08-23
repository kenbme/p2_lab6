package sapo.pessoa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import sapo.tarefa.TarefaDTO;

public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        if (pessoa.isPresent()) {
            throw new IllegalStateException("CPF já cadastrado.");
        }
        pessoaRepository.put(new PessoaImpl(cpf, nome, habilidades));
    }
    
    public void cadastraAluno(String CPF, String nome, String[] habilidades, String matricula, String periodo) {
		this.pessoaRepository.put(new Aluno(CPF, nome, habilidades, matricula, periodo));
	}
    
    public void cadastraProfessor(String CPF, String nome, String[] habilidades, String codSIAPE, String[] disciplinas) {
    	this.pessoaRepository.put(new Professor(CPF, nome, habilidades, codSIAPE, disciplinas));
    }

    public String exibirPessoa(String cpf) throws NoSuchElementException {
        return pessoaRepository.get(cpf).orElseThrow().exibir();
    }

    public void alterarNomePessoa(String cpf, String novoNome) throws NoSuchElementException {
        pessoaRepository.get(cpf).orElseThrow().alterarNome(novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) throws NoSuchElementException {
        pessoaRepository.get(cpf).orElseThrow().alterarHabilidades(novasHabilidades);
    }

    public void removerPessoa(String cpf) throws NoSuchElementException {
        pessoaRepository.get(cpf).orElseThrow();
        pessoaRepository.remove(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) throws NoSuchElementException {
        pessoaRepository.get(cpf).orElseThrow().adicionarComentario(comentario, pessoaRepository.get(autorCpf).orElseThrow().getCPF());
    }

    public String listarComentariosPessoa(String cpf) throws NoSuchElementException {
        Pessoa pessoa = pessoaRepository.get(cpf).orElseThrow();
        StringBuilder lista = new StringBuilder(pessoa.getNome() + " – " + cpf);
        lista.append("\nComentários:");
        if (pessoa.getComentarios().isEmpty()) {
            return lista.toString();
        }
        for (Comentario comentario : pessoa.getComentarios()) {
            lista.append("\n-- ").append(comentario.getDescricao());
            Optional<Pessoa> autor = pessoaRepository.get(comentario.getAutorCpf());
            if (autor.isPresent()) {
                lista.append(" (").append(autor.get().getNome()).append(")");
            } else {
                lista.append(" (REMOVIDO)");
            }
        }
        return lista.toString();
    }

    public String getNomePessoaOuFalha(String cpf) throws NoSuchElementException {
        return pessoaRepository.get(cpf).orElseThrow().getNome();
    }

    public String[] consultar(String[] dados) {
        Set<Pessoa> pessoas = pessoaRepository.consultar(dados);
        String[] resultado = new String[pessoas.size()];
        int i = 0;
        for (Pessoa pessoa : pessoas) {
            resultado[i] = pessoa.exibir();
            i++;
        }
        return resultado;
    }

	public void defineFuncaoProfessor(String CPF, String codSIAPE, String[] disciplinas) {
		Optional<Pessoa> pessoa = this.pessoaRepository.get(CPF);
		Pessoa professor = new Professor(pessoa.get().getCPF(), pessoa.get().getNome(), pessoa.get().getHabilidades().toArray(new String[0]), codSIAPE, disciplinas, pessoa.get().getTarefas(), pessoa.get().getNivel());
		this.pessoaRepository.remove(CPF);
		this.pessoaRepository.put(professor);
	}

	public void defineFuncaoAluno(String CPF, String matricula, String periodo) {
		Optional<Pessoa> pessoa = this.pessoaRepository.get(CPF);
		Pessoa aluno = new Aluno(pessoa.get().getCPF(), pessoa.get().getNome(), pessoa.get().getHabilidades().toArray(new String[0]), matricula, periodo, pessoa.get().getTarefas(), pessoa.get().getNivel());
		this.pessoaRepository.remove(CPF);
		this.pessoaRepository.put(aluno);
	}
	
	public void removeFuncao(String CPF) {
		Optional<Pessoa> funcao = this.pessoaRepository.get(CPF);
		Pessoa pessoa = new PessoaImpl(funcao.get().getCPF(), funcao.get().getNome(), funcao.get().getHabilidades().toArray(new String[0]), funcao.get().getTarefas(), funcao.get().getNivel());
		this.pessoaRepository.remove(CPF);
		this.pessoaRepository.put(pessoa);
	}
	
	public int getNivel(String CPF) {
		return this.pessoaRepository.get(CPF).get().getNivel();
	}

	public String[] listarPessoas() {
		HashSet<Pessoa> pessoas = this.pessoaRepository.getAll();
		ArrayList<String> pessoasSTR = new ArrayList<>();
		for(Pessoa pessoa : pessoas) {
			pessoasSTR.add(pessoa.toString());
		}
		return pessoasSTR.toArray(new String[0]);
	}

	public void contabilizaTarefa(TarefaDTO tarefa, String CPF) {
		this.pessoaRepository.get(CPF).get().contabilizaTarefa(tarefa);
	}
	
	public void removeTarefa(TarefaDTO tarefa, String CPF) {
		this.pessoaRepository.get(CPF).get().removeTarefa(tarefa);
	}
	
	public void contabilizaTarefaFinalizada(TarefaDTO tarefa) {
		for (String CPF : tarefa.getPessoas().keySet()){
			this.pessoaRepository.get(CPF).get().contabilizaTarefaFinalizada(tarefa);
		}
	}

	public void removeTarefaFinalizada(TarefaDTO tarefa) {
		for (String CPF : tarefa.getPessoas().keySet()){
			this.pessoaRepository.get(CPF).get().removeTarefaFinalizada(tarefa);
		}
	}

}
