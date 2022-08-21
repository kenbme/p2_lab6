package sapo.pessoa;

import java.util.ArrayList;
import java.util.Collections;

public class Aluno extends PessoaImpl {

	private String matricula;
    private String periodo;

    public Aluno(String cpf, String nome, String[] habilidades, String matricula, String periodo) {
		super(cpf, nome, habilidades);
		this.matricula = matricula;
		this.periodo = periodo;
	}
    
    public int calcularNivel() {
    	return 0;
    }
    
    public String toString() {
    	return super.getNome() + " - " + super.getCPF() + "\n" +
    				"Aluno - " + this.matricula + " - " + this.periodo + "\n" + 
    				habilidadesToString();
    }

    private String habilidadesToString() {
    	String habilidadesSTR = "";
    	ArrayList<String> habilidades = super.getHabilidades();
    	Collections.sort(habilidades);
    	for (String habilidade : habilidades) {
    		habilidadesSTR += habilidade + "\n";
    	}
    	return habilidadesSTR;
    }
}