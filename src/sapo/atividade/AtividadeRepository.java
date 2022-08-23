package sapo.atividade;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AtividadeRepository {

    private final ArrayList<Atividade> atividades;

    public AtividadeRepository() {
        atividades = new ArrayList<>();
    }

    public void put(Atividade atividade){
        atividades.add(atividade);
    }

    public Optional<Atividade> get(String atividadeID){
        int atividadePos = Integer.parseInt((atividadeID.split("-"))[1]);
        if(atividadePos >= atividades.size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(atividades.get(atividadePos));
    }

    public int totalAtividades(){
        return atividades.size();
    }

    public Set<Atividade> consultar(String[] dados) {
        Predicate<Atividade> filtro = atividade -> {
            for (String dado : dados) {
                if (atividade.getNome().toLowerCase().contains(dado)) {
                    return true;
                }
                if (atividade.getId().toLowerCase().contains(dado)) {
                    return true;
                }
                if (atividade.getDescricao().toLowerCase().contains(dado)) {
                    return true;
                }
            }
            return false;
        };
        return atividades.stream().filter(filtro).sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

}
