import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtividadeTest extends BaseTest {

    @Test
    void cadastrarAtividadeTest1() {
        String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
        Assertions.assertEquals("STD-1", facade.cadastrarAtividade("Estudar OO", descricao, cpf1));
    }

}
