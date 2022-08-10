import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sapo.Facade;
import sapo.Validador;

public class BaseTest {

    Validador validador;
    Facade facade;
    String cpf1 = "222.222.222-22";
    String cpf2 = "333.333.333-33";
    String nome1 = "Matheus Canella";
    String nome2 = "Zé Produções";
    String[] habilidades1 = new String[]{"Quack"};
    String[] habilidades2 = new String[]{};

    @BeforeEach
    void setup() {
        validador = new Validador();
        facade = new Facade();
        facade.cadastrarPessoa(cpf1, nome1, habilidades1);
        facade.cadastrarPessoa(cpf2, nome2, habilidades2);
    }

    @Test
    void validaStringEmBrancoTest() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> validador.valida(" "));
    }

    @Test
    void validaStringNullTest() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> validador.valida((String) null));
    }

    @Test
    void validaStringArrayStringEmBrancoTest() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> validador.valida(new String[]{"ola", ""}));
    }

    @Test
    void validaStringArrayStringNullTest() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> validador.valida(new String[]{"ola", null}));
    }

    @Test
    void validaStringArrayNullTest() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> validador.valida((String[]) null));
    }

}
