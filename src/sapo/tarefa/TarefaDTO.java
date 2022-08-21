package sapo.tarefa;

import java.util.HashMap;

public class TarefaDTO {
	private String ID;
	private String[] habilidadesRecomendadas;
    private HashMap<String, String> pessoas;
    
    public TarefaDTO(String[] habilidadesRecomendadas, HashMap<String, String> pessoas, String ID) {
    	this.habilidadesRecomendadas = habilidadesRecomendadas;
    	this.pessoas = pessoas;
    	this.ID = ID;
    }
    
    public String[] getHabilidadesRecomendadas() {
    	return this.habilidadesRecomendadas;
    }
    
    public HashMap<String, String> getPessoas(){
    	return this.pessoas;
    }
    
    public String getID(){
    	return this.ID;
    }
}
