import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

    Facade facade;
    String cpf1 = "222.222.222-22";
    String cpf2 = "333.333.333-33";
    String nome1 = "Matheus Canella";
    String nome2 = "Zé Produções";
    String[] habilidades1 = new String[]{"Quack"};
    String[] habilidades2 = new String[]{};

    @BeforeEach
    void setup() {
        facade = new Facade();
        facade.cadastrarPessoa(cpf1, nome1, habilidades1);
        facade.cadastrarPessoa(cpf2, nome2, habilidades2);
    }

}
