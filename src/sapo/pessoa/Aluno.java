package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

import sapo.tarefa.TarefaDTO;

public class Aluno implements Pessoa{

	private final String CPF;
    private String nome;
	private String matricula;
    private String periodo;
    private int nivel = 0;
    private int nivelAnterior = 0;
    private String funcao = "Aluno";
    private final ArrayList<String> habilidades;
    private final ArrayList<Comentario> comentarios;
    private HashMap<String, TarefaDTO> tarefasAndamento;
    private HashMap<String, TarefaDTO> tarefasFinalizadas;
    private HashMap<String, TarefaDTO> tarefasFinalizadasComHabilidades;
    private HashSet<String> tarefasAnteriores;

    public Aluno(String cpf, String nome, String[] habilidades, String matricula, String periodo) {
    	this.CPF = cpf;
        this.nome = nome;
		this.matricula = matricula;
		this.periodo = periodo;
		this.comentarios = new ArrayList<>();
		this.habilidades = new ArrayList<>();
        this.habilidades.addAll(Arrays.asList(habilidades));
		this.tarefasAndamento = new HashMap<>();
		this.tarefasFinalizadas = new HashMap<>();
		this.tarefasAnteriores = new HashSet<>();
	}
    
    public Aluno(String cpf, String nome, String[] habilidades, String matricula, String periodo, HashSet<String> tarefasAnteriores, int nivelAnterior) {
    	this.CPF = cpf;
        this.nome = nome;
		this.matricula = matricula;
		this.periodo = periodo;
		this.comentarios = new ArrayList<>();
		this.habilidades = new ArrayList<>();
        this.habilidades.addAll(Arrays.asList(habilidades));
		this.tarefasAndamento = new HashMap<>();
		this.tarefasFinalizadas = new HashMap<>();
		this.tarefasAnteriores = tarefasAnteriores;
		this.nivelAnterior = nivelAnterior;
	}
    
    public String exibir() {
    	return this.nome + " - " + this.CPF + "\n" +
    				"Aluno - " + this.matricula + " - " + this.periodo + "\n" + 
    				habilidadesToString();
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
        return CPF;
    }
    
    @Override
    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    private String habilidadesToString() {
    	String habilidadesSTR = "";
    	Collections.sort(this.habilidades);
    	for (String habilidade : this.habilidades) {
    		habilidadesSTR += habilidade + "\n";
    	}
    	return habilidadesSTR;
    }
    
    
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
			for (String habilidade : tarefa.getHabilidadesRecomendadas()) {
				if (this.habilidades.contains(habilidade)) {
					this.tarefasFinalizadasComHabilidades.put(tarefa.getID(), tarefa);
					return;
				}
			}
			this.tarefasFinalizadas.put(tarefa.getID(), tarefa);
		}
	}
    
    @Override
	public void removeTarefaFinalizada(TarefaDTO tarefa) {
    	if (!this.tarefasAnteriores.contains(tarefa.getID())) {
			this.tarefasAndamento.put(tarefa.getID(), tarefa);
			this.tarefasFinalizadas.remove(tarefa.getID());
			this.tarefasFinalizadasComHabilidades.remove(tarefa.getID());
		}
	}
    
    private void calculaNivel() {
    	int finalizadasComHabilidades = 0;
    	if (this.tarefasFinalizadasComHabilidades != null) {
    		finalizadasComHabilidades = this.tarefasFinalizadasComHabilidades.size();
    	}
    	this.nivel = (int)Math.floor(this.tarefasAndamento.size() / 2) + (int)Math.ceil(1.5 * finalizadasComHabilidades) + this.tarefasFinalizadas.size() + this.nivelAnterior;
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

	@Override
	public String getFuncao() {
		return this.funcao;
	}
}