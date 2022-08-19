package sapo.pessoa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class PessoaImpl implements Pessoa {

    private final String cpf;
    private String nome;
    private final HashSet<String> habilidades;
    private final ArrayList<Comentario> comentarios;

    public PessoaImpl(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = new HashSet<>();
        this.habilidades.addAll(Arrays.asList(habilidades));
        comentarios = new ArrayList<>();
    }

    @Override
    public String exibir() {
        StringBuilder exibicao = new StringBuilder(nome + " – " + cpf);
        ArrayList<String> habilidades = new ArrayList<>(this.habilidades);
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
    public HashSet<String> getHabilidades() {
        return habilidades;
    }

}
