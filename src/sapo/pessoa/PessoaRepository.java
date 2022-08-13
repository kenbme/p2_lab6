package sapo.pessoa;

import java.util.HashMap;
import java.util.Optional;

public class PessoaRepository {

    private final HashMap<String, Pessoa> pessoas;

    public PessoaRepository() {
        pessoas = new HashMap<>();
    }

    public Optional<Pessoa> get(String cpf) {
        return Optional.ofNullable(pessoas.get(cpf));
    }

    public void put(Pessoa pessoa) {
        pessoas.put(pessoa.getCPF(), pessoa);
    }

    public void remove(String cpf) {
        pessoas.put(cpf, null);
    }

}
