package pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class PessoaRepository {

    Map<String, Pessoa> pessoas;

    // TODO POSSIVEL REFATORACAO NAS VERIFICACOES DE NULL
    public PessoaRepository() {
        pessoas = new HashMap<>();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        pessoas.put(cpf, new PessoaImpl(cpf, nome, habilidades));
    }

    public String exibirPessoa(String cpf) throws NoSuchElementException {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }
        return pessoa.exibir();
    }

    public void alterarNomePessoa(String cpf, String novoNome) throws NoSuchElementException {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }
        pessoa.alterarNome(novoNome);
    }

    public void alterarHabilidadesPessoa(String cpf, String[] novasHabilidades) {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }
        pessoa.alterarHabilidades(novasHabilidades);
    }

    public void removerPessoa(String cpf) {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }
        pessoas.put(cpf, null);
    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {
        Pessoa pessoa = pessoas.get(cpf);
        Pessoa autor = pessoas.get(autorCpf);
        if (pessoa == null || autor == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }
        pessoa.adicionarComentario(comentario, autor);
    }

    public String listarComentariosPessoa(String cpf) {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }
        return pessoa.listarComentarios();
    }
}
