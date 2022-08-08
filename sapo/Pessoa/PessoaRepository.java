package Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class PessoaRepository {

    Map<String, Pessoa> pessoas;

    public PessoaRepository() {
        pessoas = new HashMap<>();
    }

    public void cadastrarPessoa(String cpf, String nome, String[] habilidades) {
        pessoas.put(cpf, new PessoaImpl(cpf, nome, habilidades));
    }

    public String exibirPessoa(String cpf) {
        Pessoa pessoa = pessoas.get(cpf);
        if (pessoa == null) {
            throw new NoSuchElementException("CPF não encontrado");
        }
        return pessoa.exibir();
    }

}
