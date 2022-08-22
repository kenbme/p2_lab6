import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BuscaTest extends BaseTest {

	private String parametroNulo = "Era esperado um erro ao tentar pasar um parametro nulo";
	private String parametroVazio = "Era esperado um erro ao tentar passar um parametro vazio";
	private String parametroInexistente = "Era esperado um erro ao tentar passar um parametro inexistente";
	private String naoECPF = "Era esperado um erro ao tentar passar algo que não seja CPF";
	
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
    
    @Test
    void exibirPessoasStringsInvalidas() {
    	try {
    		facade.exibirPessoas(null);
    		Assertions.fail(parametroNulo + " - Consulta");
    	} catch (NullPointerException npe) {}
    	try {
    		facade.exibirPessoas("ConsultaNãoExiste");
    		Assertions.fail(parametroInexistente + " - Consulta");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void buscarAtividadesStringsInvalidas() {
    	try {
    		facade.buscarAtividade(null);
    		Assertions.fail(parametroNulo + " - Consulta");
    	} catch (NullPointerException npe) {}
    	try {
    		facade.buscarAtividade("IDNãoExiste");
    		Assertions.fail(parametroInexistente + " - Consulta");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void buscarTarefasStringsInvalidas() {
    	try {
    		facade.buscarTarefas(null);
    		Assertions.fail(parametroNulo + " - Nome");
    	} catch (NullPointerException npe) {}
    	try {
    		facade.buscarTarefas("NãoTemNiguém");
    		Assertions.fail(parametroInexistente + " - Nome");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.buscarTarefas(null, nome1);
    		Assertions.fail(parametroNulo + " - ID");
    	} catch (NullPointerException npe) {}
    	try {
    		facade.buscarTarefas("IDNãoExiste", nome1);
    		Assertions.fail(parametroInexistente + " - ID");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.buscarTarefas(atividade1, null);
    		Assertions.fail(parametroNulo + " - nome");
    	} catch (NullPointerException npe) {}
    }
}
