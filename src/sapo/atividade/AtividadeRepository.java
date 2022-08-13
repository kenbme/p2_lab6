package sapo.atividade;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Optional;

public class AtividadeRepository {

    private ArrayList<Atividade> atividades;

    public AtividadeRepository() {
        atividades = new ArrayList<>();
    }

    public void put(Atividade atividade){
        atividades.add(atividade);
    }

    public Optional<Atividade> get(String atividadeID){
        int atividadePos = Integer.parseInt((atividadeID.split("-"))[1]);
        if(atividadePos > atividades.size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(atividades.get(atividadePos));
    }

    public int totalAtividades(){
        return atividades.size();
    }
}
