package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PessoaImpl implements Pessoa {

    private final String cpf;
    private String nome;
    private int nivel = 0;
    private final ArrayList<String> habilidades;
    private final ArrayList<Comentario> comentarios;

    public PessoaImpl(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = new ArrayList<>();
        this.habilidades.addAll(Arrays.asList(habilidades));
        comentarios = new ArrayList<>();
    }
    
    public int calculaNivel() {
    	return 0;
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
    
    public int getNivel() {
    	return this.nivel;
    }
    
    public void setNivel(int nivel) {
    	this.nivel = nivel;
    }

}
