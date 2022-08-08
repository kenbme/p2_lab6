import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PessoaTest extends BaseTest {

    @Test
    void adicionarPessoaTest1() {
        String cpf = "111.111.111-11";
        String nome = "Matheus Gaudencio do Rêgo";
        String[] habilidades = new String[]{"Desenvolvimento web", "Professor", "Programador"};
        facade.cadastrarPessoa(cpf, nome, habilidades);
        Assertions.assertEquals("Matheus Gaudencio do Rêgo – 111.111.111-11\n- Desenvolvimento web\n- Professor\n- Programador"  ,facade.exibirPessoa(cpf));
    }

}
