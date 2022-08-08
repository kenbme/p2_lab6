package Pessoa;

import Comentario.Comentario;
import Comentario.ComentarioImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PessoaImpl implements Pessoa {

    private final String cpf;
    private String nome;
    private final List<String> habilidades;
    private final List<Comentario> comentarios;

    public PessoaImpl(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = new ArrayList<>();
        this.habilidades.addAll(Arrays.asList(habilidades));
        comentarios = new ArrayList<>();
    }

    @Override
    public String exibir() {
        StringBuilder exibicao = new StringBuilder(nome + " – " + cpf);
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
    public void adicionarComentario(String comentario, Pessoa autor) {
        comentarios.add(new ComentarioImpl(comentario, autor));
    }

    @Override
    public String listarComentarios() {
        StringBuilder lista = new StringBuilder(nome + " – " + cpf);
        if (comentarios.isEmpty()) {
            return lista.toString();
        }
        lista.append("\nComentários:");
        for (Comentario comentario : comentarios) {
            lista.append("\n-- ").append(comentario.exibir());
        }
        return lista.toString();
    }

    @Override
    public String getNome() {
        return nome;
    }

}
