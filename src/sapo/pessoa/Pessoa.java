package sapo.pessoa;

import java.util.ArrayList;

public interface Pessoa {

    String exibir();
    void alterarNome(String novoNome);
    void alterarHabilidades(String[] novasHabilidades);
    void adicionarComentario(String comentario, Pessoa autor);
    String listarComentarios();
    String getNome();
    String getCPF();
    ArrayList<String> getHabilidades();

}
