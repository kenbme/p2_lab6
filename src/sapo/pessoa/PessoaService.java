package sapo.pessoa;

import java.util.*;

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

    public String exibirPessoa(String cpf) throws NoSuchElementException {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        if (pessoa.isEmpty()) {
            throw new NoSuchElementException("CPF não encontrado.");
        }
        return pessoa.get().exibir();
    }

    public void alterarNomePessoa(String cpf, String novoNome) throws NoSuchElementException {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        if (pessoa.isEmpty()) {
            throw new NoSuchElementException("CPF não encontrado.");
        }
        pessoa.get().alterarNome(novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) throws NoSuchElementException {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        if (pessoa.isEmpty()) {
            throw new NoSuchElementException("CPF não encontrado.");
        }
        pessoa.get().alterarHabilidades(novasHabilidades);
    }

    public void removerPessoa(String cpf) throws NoSuchElementException {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        if (pessoa.isEmpty()) {
            throw new NoSuchElementException("CPF não encontrado.");
        }
        pessoaRepository.remove(cpf);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) throws NoSuchElementException {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        Optional<Pessoa> autor = pessoaRepository.get(autorCpf);
        if (pessoa.isEmpty() || autor.isEmpty()) {
            throw new NoSuchElementException("CPF não encontrado.");
        }
        pessoa.get().adicionarComentario(comentario, autor.get());
    }

    public String listarComentariosPessoa(String cpf) throws NoSuchElementException {
        Optional<Pessoa> pessoa = pessoaRepository.get(cpf);
        if (pessoa.isEmpty()) {
            throw new NoSuchElementException("CPF não encontrado.");
        }
        return pessoa.get().listarComentarios();
    }

    public Optional<Pessoa> getPessoa(String cpf) {
        return pessoaRepository.get(cpf);
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
    
    public String getNomePessoa (String CPF) {
    	return this.pessoaRepository.getNome(CPF);
    }

}
