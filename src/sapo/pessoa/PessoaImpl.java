package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import sapo.tarefa.TarefaDTO;

public class PessoaImpl implements Pessoa {

    private final String cpf;
    private String nome;
    private int nivel;
    private int nivelAnterior;
    private HashMap<String, TarefaDTO> tarefasAndamento;
    private HashMap<String, TarefaDTO> tarefasFinalizadas;
    private HashSet<String> tarefasAnteriores;
    private final ArrayList<String> habilidades;
    private final ArrayList<Comentario> comentarios;

    public PessoaImpl(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.nivel = 0;
        this.nivelAnterior = 0;
        this.habilidades = new ArrayList<>();
        this.habilidades.addAll(Arrays.asList(habilidades));
        comentarios = new ArrayList<>();
		this.tarefasAndamento = new HashMap<>();
		this.tarefasFinalizadas = new HashMap<>();
		this.tarefasAnteriores = new HashSet<>();
    }
    
    public PessoaImpl(String cpf, String nome, String[] habilidades, HashSet<String> tarefasAnteriores, int nivelAnterior) {
        this.cpf = cpf;
        this.nome = nome;
        this.nivel = 0;
        this.habilidades = new ArrayList<>();
        this.habilidades.addAll(Arrays.asList(habilidades));
        comentarios = new ArrayList<>();
		this.tarefasAndamento = new HashMap<>();
		this.tarefasFinalizadas = new HashMap<>();
		this.tarefasAnteriores = tarefasAnteriores;
		this.nivelAnterior = nivelAnterior;
    }

    @Override
    public String exibir() {
        StringBuilder exibicao = new StringBuilder(nome + " – " + cpf);
        Collections.sort(habilidades);
        for (String habilidade : habilidades) {
            exibicao.append("\n- ").append(habilidade);
        }
        return exibicao.toString();
    }

    @Override
    public void alterarNome(String novoNome) {
        nome = novoNome;
    }

    @Override
    public void alterarHabilidades(String[] novasHabilidades) {
        this.habilidades.addAll(Arrays.asList(novasHabilidades));
    }

    @Override
    public void adicionarComentario(String comentario, String autorCpf) {
        comentarios.add(new Comentario(comentario, autorCpf));
    }

    @Override
    public ArrayList<Comentario> getComentarios() {
        return comentarios;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCPF() {
        return cpf;
    }

    @Override
    public ArrayList<String> getHabilidades() {
        return habilidades;
    }
    
    @Override
    public int getNivel() {
    	calculaNivel();
    	return this.nivel;
    }

    @Override
	public void contabilizaTarefa(TarefaDTO tarefa) {
		if (!this.tarefasAnteriores.contains(tarefa.getID())) {
			this.tarefasAndamento.put(tarefa.getID(), tarefa);
		}
	}
    
    @Override
	public void removeTarefa(TarefaDTO tarefa) {
    	if (!this.tarefasAnteriores.contains(tarefa.getID())) {
			this.tarefasAndamento.remove(tarefa.getID());
		}
	}
    
    @Override
	public void contabilizaTarefaFinalizada(TarefaDTO tarefa) {
		if (!this.tarefasAnteriores.contains(tarefa.getID())) {
			this.tarefasAndamento.remove(tarefa.getID());
			this.tarefasFinalizadas.put(tarefa.getID(), tarefa);
		}
	}
    
    @Override
	public void removeTarefaFinalizada(TarefaDTO tarefa) {
    	if (!this.tarefasAnteriores.contains(tarefa.getID())) {
			this.tarefasAndamento.put(tarefa.getID(), tarefa);
			this.tarefasFinalizadas.remove(tarefa.getID());
		}
	}
	
	private void calculaNivel() {
		this.nivel = (int)Math.floor(this.tarefasAndamento.size() / 2) + this.tarefasFinalizadas.size() + this.nivelAnterior;
	}

	@Override
	public HashSet<String> getTarefas() {
		HashSet<String> tarefasTotais = new HashSet<>();
		for (TarefaDTO tarefa : this.tarefasAndamento.values()) {
			tarefasTotais.add(tarefa.getID());
		}
		for (TarefaDTO tarefa : this.tarefasFinalizadas.values()) {
			tarefasTotais.add(tarefa.getID());
		}
		for (String tarefaID : this.tarefasAnteriores) {
			tarefasTotais.add(tarefaID);
		}
		return tarefasTotais;
	}
	
}
