package sapo.pessoa;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
        pessoas.remove(cpf);
    }

    public Set<Pessoa> consultar(String[] dados) {
        Predicate<Pessoa> filtro = pessoa -> {
            for (String dado : dados) {
                if (List.of(pessoa.getNome().toLowerCase().split(" ")).contains(dado)) {
                    continue;
                }
                boolean contem_habilidade = false;
                for (String habilidade : pessoa.getHabilidades()) {
                    if (habilidade.toLowerCase().contains(dado)) {
                        contem_habilidade = true;
                        break;
                    }
                }
                if (contem_habilidade) {
                    continue;
                }
                return false;
            }
            return true;
        };
        return this.pessoas.values().stream()
                .filter(filtro).sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public HashSet<Pessoa> getAll(){
        return new HashSet<>(this.pessoas.values());
    }
    
}
