public class Facade {

    // TODO SEPARAR RESPONSABILIDADES
    public Facade() {
        // TODO CONTROLLERS
    }

    // PESSOA
    public void cadastrarPessoa(String cpf, String nome, str[] habilidades) {

    }

    public String exibirPessoa(String cpf) {

    }

    public void alterarNomePessoa(String cpf, String novoNome) {

    }

    public void alterarHabilidadesPessoa(String cpf, str[] novasHabilidades) {

    }

    public void removerPessoa(String cpf) {

    }

    public void adicionarComentarioPessoa(String cpf, String comentario, String autorCpf) {

    }

    public String listarComentariosPessoa(String cpf) {

    }

    // ATIVIDADE
    public String cadastrarAtividade(String nome, String descricao, String cpf) {

    }

    public void encerrarAtividade(String atividadeId) {

    }

    public void desativarAtividade(String atividadeId) {

    }

    public void reabrirAtividade(String atividadeId) {

    }

    public String exibirAtividade(String atividadeId) {

    }

    public void alterarDescricaoAtividade(String atividadeId, String descricao) {

    }

    public void alterarResponsavelAtividade(String atividadeId, String cpf) {

    }

    // TAREFA
    public String cadastrarTarefa(String atividadeId, String nome, str[] habilidades) {

    }

    public void alterarNomeTarefa(String idTarefa, String novoNome) {

    }

    public void alterarHabilidadesTarefa(String idTarefa, str[] habilidades) {

    }

    public void adicionarHorasTarefa(String idTarefa, int horas) {

    }

    public void removerHorasTarefa(String idTarefa, int horas) {

    }

    public void concluirTarefa(String idTarefa) {

    }

    public void removerTarefa(String idTarefa) {

    }

    public String exibirTarefa(String idTarefa) {

    }

    public void associarPessoaTarefa(String cpf, String idTarefa) {

    }

    public void removerPessoaTarefa(String cpf, String idTarefa) {

    }

}
