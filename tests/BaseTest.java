import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    Facade facade;

    @BeforeEach
    void setup() {
        facade = new Facade();
    }

}
