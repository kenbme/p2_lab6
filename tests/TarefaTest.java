import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class TarefaTest extends BaseTest {

    @Test
    void cadastrarTarefa1() {
        Assertions.assertEquals("STD-0-1", facade.cadastrarTarefa(atividade1, "Montar documentação.", new String[]{"OO"}));
    }

    @Test
    void cadastrarTarefaGerencial1() {
        Assertions.assertEquals("STD-0-1", facade.cadastrarTarefaGerencial(atividade1, "Tarefa gerencial",
                new String[]{"OO", "Herança", "Professor"}, new String[]{tarefa1}));
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
    void exibirTarefa2() {
        String id = facade.cadastrarTarefa(atividade1, "Aula sobre herança", new String[]{"OO", "Herança", "Professor"});
        facade.adicionarHorasTarefa(id, 20);
        facade.removerHorasTarefa(id, 40);
        facade.associarPessoaTarefa(cpf1, id);
        facade.removerPessoaTarefa(cpf1, id);
        Assertions.assertEquals(
                "Aula sobre herança - STD-0-1\n" +
                        "- Estudar OO\n" +
                        "OO, Herança, Professor\n" +
                        "(0 hora(s) executada(s))\n" +
                        "===\n" +
                        "Equipe:"
                ,
                facade.exibirTarefa(id));
    }

    @Test
    void exibirTarefa3() {
        String id = facade.cadastrarTarefa(atividade1, "Aula sobre herança", new String[]{"OO", "Herança", "Professor"});
        Assertions.assertEquals(
                "Aula sobre herança - STD-0-1\n" +
                        "- Estudar OO\n" +
                        "OO, Herança, Professor\n" +
                        "(0 hora(s) executada(s))\n" +
                        "===\n" +
                        "Equipe:"
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
                        "gestão, OO, Herança, Professor\n" +
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

    @Test
    void entradasNullInvalidas() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarTarefa(null, null, null));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarTarefa("STD-0", null, null));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarTarefa("STD-0", "a", null));
    }

    @Test
    void entradasVaziasInvalidas() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarTarefa("", "", new String[]{""}));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarTarefa("STD-0", "", new String[]{""}));
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarTarefa("STD-0", "a", new String[]{""}));
    }

    @Test
    void alterarNome() {
        facade.alterarNomeTarefa(tarefa1, "Novo nome de tarefa1");
        Assertions.assertEquals(
                "Novo nome de tarefa1 - STD-0-0\n" +
                        "- Estudar OO\n" +
                        "OO\n" +
                        "(0 hora(s) executada(s))\n" +
                        "===\n" +
                        "Equipe:", facade.exibirTarefa(tarefa1));
        Assertions.assertEquals(
                "STD-0: Estudar OO\n" +
                        "Responsável: Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
                        "===\n" +
                        "Tarefas: 0/1\n" +
                        "- Novo nome de tarefa1 - STD-0-0",
                facade.exibirAtividade(atividade1));
    }

    @Test
    void removerTarefa() {
        facade.removerTarefa(tarefa1);
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.exibirTarefa(tarefa1));
        Assertions.assertEquals(
                "STD-0: Estudar OO\n" +
                        "Responsável: Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
                        "===\n" +
                        "Tarefas: 0/1",
                facade.exibirAtividade(atividade1));
    }

    @Test
    void concluirTarefa() {
        String id = facade.cadastrarTarefa(atividade1, "Aula sobre herança", new String[]{"OO", "Herança", "Professor"});
        facade.associarPessoaTarefa(cpf1, id);
        facade.adicionarHorasTarefa(id, 20);
        facade.concluirTarefa(id);
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
    void concluirTarefa2() {
        String id = facade.cadastrarTarefa(atividade1, "Aula sobre herança", new String[]{"OO", "Herança", "Professor"});
        facade.concluirTarefa(id);
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.alterarNomeTarefa(id, "novo nome"));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.alterarHabilidadesTarefa(id, new String[]{"habilidade nova"}));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.adicionarHorasTarefa(id, 20));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.removerHorasTarefa(id, 20));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.associarPessoaTarefa(cpf1, id));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.removerPessoaTarefa(cpf1, id));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.concluirTarefa(id));
    }

    @Test
    void concluirTarefaGerencial1() {
        String id = facade.cadastrarTarefaGerencial(atividade1, "Tarefa gerencial",
                new String[]{"OO", "Herança", "Professor"}, new String[]{tarefa1});
        facade.concluirTarefa(id);
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.alterarNomeTarefa(id, "novo nome"));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.alterarHabilidadesTarefa(id, new String[]{"habilidade nova"}));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.adicionarHorasTarefa(id, 20));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.removerHorasTarefa(id, 20));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.associarPessoaTarefa(cpf1, id));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.removerPessoaTarefa(cpf1, id));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.concluirTarefa(id));
    }

    @Test
    void concluirTarefaGerencial2() {
        String id = facade.cadastrarTarefaGerencial(atividade1, "Tarefa gerencial",
                new String[]{"OO", "Herança", "Professor"}, new String[]{tarefa1});
        facade.concluirTarefa(id);
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.adicionarNaTarefaGerencial(id, "tarefa"));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.removerDaTarefaGerencial(id, "tarefa"));
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.contarTodasTarefasNaTarefaGerencial(id));
    }

    @Test
    void funcoesTarefaGerencial() {
        String id = facade.cadastrarTarefaGerencial(atividade1, "Tarefa gerencial",
                new String[]{"OO", "Herança", "Professor"}, new String[]{tarefa1});
        facade.adicionarNaTarefaGerencial(id, tarefa1);
        facade.associarPessoaTarefa(cpf1, id);
        facade.adicionarHorasTarefa(id, 100);
        facade.removerHorasTarefa(id, 30);
        Assertions.assertEquals(
                "Tarefa gerencial - STD-0-1\n" +
                        "- Estudar OO\n" +
                        "gestão, OO, Herança, Professor\n" +
                        "(70 hora(s) executada(s))\n" +
                        "===\n" +
                        "Equipe:\n" +
                        "Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "Tarefas:\n" +
                        "- Preparar material de estudo - STD-0-0"
                ,
                facade.exibirTarefa(id)
        );
        Assertions.assertEquals(facade.contarTodasTarefasNaTarefaGerencial(id), 1);
        facade.removerDaTarefaGerencial(id, tarefa1);
        facade.removerPessoaTarefa(cpf1, id);
        Assertions.assertEquals(
                "Tarefa gerencial - STD-0-1\n" +
                        "- Estudar OO\n" +
                        "gestão, OO, Herança, Professor\n" +
                        "(70 hora(s) executada(s))\n" +
                        "===\n" +
                        "Equipe:\n" +
                        "===\n" +
                        "Tarefas:"
                ,
        facade.exibirTarefa(id)
        );
    }

    @Test
    void impedirCriarCiclo() {
        String id = facade.cadastrarTarefaGerencial(atividade1, "Tarefa gerencial",
                new String[]{"OO", "Herança", "Professor"}, new String[]{tarefa1});
        String id2 = facade.cadastrarTarefaGerencial(atividade1, "Tarefa gerencial",
                new String[]{"OO", "Herança", "Professor"}, new String[]{id});
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> {facade.adicionarNaTarefaGerencial(id, id2);});
    }

}
