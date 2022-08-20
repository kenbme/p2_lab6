import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

public class BuscaTest extends BaseTest {

    @Test
    void buscaPessoaTest1() {
        Assertions.assertEquals(Arrays.toString(new String[]{
                        "Matheus Canella – 222.222.222-22\n- Quack",
                        "Matheus Gaudencio do Rêgo – 555.555.555-55\n- Java"
                })
                , Arrays.toString(facade.exibirPessoas("Matheus")));
    }

    @Test
    void buscaPessoaTest2() {
        Assertions.assertEquals(Arrays.toString(new String[]{
                        "Matheus Gaudencio do Rêgo – 555.555.555-55\n- Java"
                })
                , Arrays.toString(facade.exibirPessoas("Matheus Java")));
    }

    @Test
    void buscasMaisRecentes1() {
        facade.exibirPessoas("Matheus");
        facade.exibirPessoas("Matheus Java");
        Assertions.assertEquals(Arrays.toString(new String[]{
                "Matheus Gaudencio do Rêgo – 555.555.555-55\n" +
                        "- Java"
        }), Arrays.toString(facade.buscasMaisRecentes(1)));
    }

    @Test
    void buscasMaisRecentes2() {
        facade.exibirPessoas("Matheus");
        facade.exibirPessoas("Matheus Java");
        Assertions.assertEquals(Arrays.toString(new String[]{
                "Matheus Gaudencio do Rêgo – 555.555.555-55\n" +
                        "- Java, Matheus Canella – 222.222.222-22\n" +
                        "- Quack, Matheus Gaudencio do Rêgo – 555.555.555-55\n" +
                        "- Java"
        }), Arrays.toString(facade.buscasMaisRecentes(2)));
    }



}
