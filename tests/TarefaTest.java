import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaTest extends BaseTest {

    @Test
    void cadastrarTarefa1() {
        Assertions.assertEquals("STD-0-1", facade.cadastrarTarefa(atividade1, "Montar documentação.", new String[]{"OO"}));
    }

    @Test
    void exibirTarefa1() {
        String id = facade.cadastrarTarefa(atividade1, "Aula sobre herança", new String[]{"OO", "Herança", "Professor"});
        facade.associarPessoaTarefa(cpf1, id);
        facade.adicionarHorasTarefa(id, 20);
        Assertions.assertEquals(
                "Aula sobre herança - STD-0-1\n" +
                        "- Estudar OO\n" +
                        "OO, Herança, Professor\n" +
                        "(20 hora(s) executada(s))\n" +
                        "===\n" +
                        "Equipe:\n" +
                        "Matheus Canella – 222.222.222-22"
                ,
                facade.exibirTarefa(id));
    }

    @Test
    void exibirTarefaGerencial1() {
        String id = facade.cadastrarTarefaGerencial(atividade1, "Tarefa gerencial",
                new String[]{"OO", "Herança", "Professor"}, new String[]{tarefa1});
        facade.associarPessoaTarefa(cpf1, id);
        facade.adicionarHorasTarefa(id, 20);
        Assertions.assertEquals(
                "Tarefa gerencial - STD-0-1\n" +
                        "- Estudar OO\n" +
                        "OO, Herança, Professor\n" +
                        "(20 hora(s) executada(s))\n" +
                        "===\n" +
                        "Equipe:\n" +
                        "Matheus Canella – 222.222.222-22" +
                        "\n===\n" +
                        "Tarefas:\n" +
                        "- Preparar material de estudo - STD-0-0"
                ,
                facade.exibirTarefa(id));
    }

}
