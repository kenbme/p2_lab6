package Pessoa;

public class PessoaImpl implements Pessoa {

    private final String cpf;
    private String nome;
    private String[] habilidades;

    public PessoaImpl(String cpf, String nome, String[] habilidades) {
        this.cpf = cpf;
        this.nome = nome;
        this.habilidades = habilidades;
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

    }

    @Override
    public void alterarHabilidades(String[] novasHabilidades) {

    }

    @Override
    public void adicionarComentario(String comentario, String autorCpf) {

    }

    @Override
    public String listarComentarios() {
        return null;
    }

}
