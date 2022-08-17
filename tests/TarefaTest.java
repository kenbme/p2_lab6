import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TarefaTest extends BaseTest {

    @Test
    void cadastrarTarefaTest1() {
        Assertions.assertEquals("STD-0-1", facade.cadastrarTarefa(atividade1, "Montar documentação.", new String[]{"OO"}));
    }

    @Test
    void exibirTarefa1() {
        Assertions.assertEquals(
                "Preparar material de estudo - STD-0-0\n" +
                        "- Estudar OO\n" +
                        "OO\n" +
                        "(0 hora(s) executada(s)\n" +
                        "===\n" +
                        "Equipe:"
                ,
                facade.exibirTarefa("STD-0-0"));
    }

}
