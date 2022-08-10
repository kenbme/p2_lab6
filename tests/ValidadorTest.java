import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidadorTest extends BaseTest {

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
