package sapo.pessoa;

import java.util.ArrayList;
import java.util.Collections;

public class Professor extends PessoaImpl {

	private String codSIAPE;
    private String[] disciplinas;
    
    public Professor(String cpf, String nome, String[] habilidades, String codSIAPE, String[] disciplinas) {
		super(cpf, nome, habilidades);
		this.codSIAPE = codSIAPE;
		this.disciplinas = disciplinas;
	}
    
    public int calcularNivel() {
    	return 0;
    }
    
    public String toString() {
    	return super.getNome() + " - " + super.getCPF() + "\n" +
				"Professor - " + this.codSIAPE+ " - " + disciplinasToString() + "\n" + 
				habilidadesToString();
    }

    private String disciplinasToString() {
    	String dts = "";
    	for (String d : this.disciplinas) {
    		dts += d;
    	}
    	return dts;
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