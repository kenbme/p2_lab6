package sapo.pessoa;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

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

    public String getNomePessoa(String cpf) {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        if (pessoa.isEmpty()) {
            return "";
        }
        return pessoa.get().getNome();
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
        Arrays.sort(resultado);
        return resultado;
    }

	public void defineFuncaoProfessor(String CPF, String codSIAPE, String[] disciplinas) {
		Pessoa pessoa = this.pessoaRepository.get(CPF).orElseThrow();
		Pessoa professor = new Professor(pessoa.getCPF(), pessoa.getNome(), pessoa.getHabilidades().toArray(new String[0]), codSIAPE, disciplinas);
		professor.setNivel(pessoa.getNivel());
		this.pessoaRepository.remove(CPF);
		this.pessoaRepository.put(professor);
	}

}
