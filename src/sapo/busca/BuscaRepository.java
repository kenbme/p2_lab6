package sapo.busca;

import java.util.ArrayList;
import java.util.Optional;

public class BuscaRepository {

    private final ArrayList<Busca> buscas;

    public BuscaRepository() {
        buscas = new ArrayList<>();
    }

    public Optional<Busca> get(int index) {
        if (index >= buscas.size()) {
            return Optional.empty();
        }
        return Optional.ofNullable(buscas.get(index));
    }

    public void put(Busca busca) {
        buscas.add(busca);
    }

    public int totalBuscas() {
        return buscas.size();
    }

}
