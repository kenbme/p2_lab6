package sapo.pessoa;

public class Comentario {

    private final String descricao;
    private final String data;
    private final String autorCpf;

    public Comentario(String descricao, String autorCpf) {
        this.descricao = descricao;
        this.autorCpf = autorCpf;
        data = java.time.LocalDate.now().toString();
    }

    public String getDescricao() {
        return descricao;
    }

    public String getAutorCpf() {
        return autorCpf;
    }

    public String getData() {
        return data;
    }

}
