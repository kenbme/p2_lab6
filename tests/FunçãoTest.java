import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class FunçãoTest extends BaseTest{

    @Test
    void alterarParaMesmaFunção(){
        facade.cadastraAluno(cpf5, nome5, habilidades5, "12345", "3");
        facade.cadastraProfessor(cpf6, nome6, habilidades6, "12345", disciplinas);
        try{
            facade.defineFuncaoAluno(cpf5, "12345", "3");
            Assertions.fail("Mudança de estado Ilegal");
        } catch (IllegalStateException hey) {}
        try{
            facade.defineFuncaoProfessor(cpf6, "12345", disciplinas);
            Assertions.fail("Mudança de estado Ilegal");
        } catch (IllegalStateException hey) {}
    }

    @Test
    void listarEmOrdemCorreta(){
        throw new RuntimeException();

    }

    @Test
    void testaCalculoNivelProfessor(){
        throw new RuntimeException();

    }

    @Test
    void testaCalculoNivelAluno(){
        facade.cadastrarPessoa(cpf5, nome5, habilidades5);

        Assertions.assertEquals(0, facade.pegarNivel(cpf5)); //Pedro começa sem função

        String atividadeTest = facade.cadastrarAtividade("Atestividade", "É pra testar...", cpf5);
        String tarefaTest1 = facade.cadastrarTarefa(atividadeTest, "umaTarefa", habilidades3);
        String tarefaTest2 = facade.cadastrarTarefa(atividadeTest, "outraTarefa", habilidades3);
        String tarefaTest3 = facade.cadastrarTarefa(atividadeTest, "maisUmaTarefa", habilidades3);
        facade.associarPessoaTarefa(cpf5, tarefaTest1);
        facade.associarPessoaTarefa(cpf5, tarefaTest2);
        facade.associarPessoaTarefa(cpf5, tarefaTest3);

        Assertions.assertEquals(1, facade.pegarNivel(cpf5)); //Pedro recebe a atribuição de 3 tarefas em andamento (A, B e C)

        facade.concluirTarefa(tarefaTest1);

        Assertions.assertEquals(2, facade.pegarNivel(cpf5)); //A tarefa A de Pedro é finalizada

        facade.defineFuncaoAluno(cpf5, "12345", "3");

        Assertions.assertEquals(2, facade.pegarNivel(cpf5)); //Pedro troca de função para aluno

        String tarefaTest4 = facade.cadastrarTarefa(atividadeTest, "quantasTarefas...", habilidades5);
        String tarefaTest5 = facade.cadastrarTarefa(atividadeTest, "semComentarios", habilidades3);
        String tarefaTest6 = facade.cadastrarTarefa(atividadeTest, "aUltima", habilidades3);
        facade.associarPessoaTarefa(cpf5, tarefaTest4);
        facade.associarPessoaTarefa(cpf5, tarefaTest5);
        facade.associarPessoaTarefa(cpf5, tarefaTest6);

        Assertions.assertEquals(3, facade.pegarNivel(cpf5)); //Pedro recebe a atribuição de 3 novas tarefas (D, E, F)

        facade.concluirTarefa(tarefaTest4);

        Assertions.assertEquals(5, facade.pegarNivel(cpf5)); //A tarefa F é finalizada e a tarefa tinha uma habilidade que pedro tinha

        facade.removeFuncao(cpf5);
        facade.removerTarefa(tarefaTest4);

        Assertions.assertEquals(5, facade.pegarNivel(cpf5)); //Pedro perde a função
    }

}
