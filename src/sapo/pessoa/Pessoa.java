package sapo.pessoa;

import java.util.ArrayList;
import java.util.HashSet;

public interface Pessoa {

    String exibir();
    void alterarNome(String novoNome);
    void alterarHabilidades(String[] novasHabilidades);
    void adicionarComentario(String comentario, String autorCpf);
    String getNome();
    String getCPF();
    HashSet<String> getHabilidades();
    ArrayList<Comentario> getComentarios();

}
