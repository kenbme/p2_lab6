package sapo.pessoa;

import java.util.ArrayList;
import java.util.HashSet;

import sapo.tarefa.TarefaDTO;

public interface Pessoa {

    String exibir();
    void alterarNome(String novoNome);
    void alterarHabilidades(String[] novasHabilidades);
    void adicionarComentario(String comentario, String autorCpf);
    String getNome();
    String getCPF();
    ArrayList<String> getHabilidades();
    ArrayList<Comentario> getComentarios();
    int getNivel();
    void contabilizaTarefa(TarefaDTO tarefa);
    void removeTarefa(TarefaDTO tarefa);
    void contabilizaTarefaFinalizada(TarefaDTO tarefa);
	void removeTarefaFinalizada(TarefaDTO tarefa);
	HashSet<String> getTarefas();
}
