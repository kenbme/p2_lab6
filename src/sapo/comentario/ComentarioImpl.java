package sapo.comentario;

import sapo.pessoa.Pessoa;

public class ComentarioImpl implements Comentario {

    private final String descricao;
    private final Pessoa autor;
    private final String data;

    public ComentarioImpl(String descricao, Pessoa autor) {
        this.descricao = descricao;
        this.autor = autor;
        data = java.time.LocalDate.now().toString();
    }

    @Override
    public String exibir() {
        return descricao + " (" + autor.getNome() + ")";
    }

}
