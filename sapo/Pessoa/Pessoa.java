package Pessoa;

public interface Pessoa {

    String exibir();
    void alterarNome(String novoNome);
    void alterarHabilidades(String[] novasHabilidades);
    void adicionarComentario(String comentario, String autorCpf);
    String listarComentarios();

}
