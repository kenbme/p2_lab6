import org.junit.jupiter.api.BeforeEach;
import sapo.Facade;
import sapo.Validador;
import sapo.atividade.AtividadeRepository;
import sapo.pessoa.PessoaRepository;
import sapo.tarefa.TarefaRepository;

public class BaseTest {

    Validador validador;
    Facade facade;
    String cpf1 = "222.222.222-22";
    String cpf2 = "333.333.333-33";
    String cpf3 = "444.444.444-44";
    String nome1 = "Matheus Canella";
    String nome2 = "Zé Produções";
    String nome3 = "João Veríssimo";
    String[] habilidades1 = new String[]{"Quack"};
    String[] habilidades2 = new String[]{};
    String[] habilidades3 = new String[]{"jogador", "atendente"};
    String cpf4 = "555.555.555-55";
    String nome4 = "Matheus Gaudencio do Rêgo";
    String[] habilidades4 = new String[]{"Java"};

    String cpf5 = "666.666.666-66";

    String nome5 = "Aluno da Silva";

    String[] habilidades5 = new String[]{"Estudar"};
    String cpf6 = "777.777.777-77";

    String nome6 = "Professor da Silva";

    String[] habilidades6 = new String[]{"Ensinar"};
    String[] disciplinas = new String[]{"Java", "EDA", "LEDA"};

    String atividade1;
    String tarefa1;

    @BeforeEach
    void setup() {
        validador = new Validador();
        facade = new Facade(new PessoaRepository(), new AtividadeRepository(), new TarefaRepository());

        facade.cadastrarPessoa(cpf1, nome1, habilidades1);
        facade.cadastrarPessoa(cpf2, nome2, habilidades2);
        facade.cadastrarPessoa(cpf3, nome3, habilidades3);
        facade.cadastrarPessoa(cpf4, nome4, habilidades4);

        atividade1 = facade.cadastrarAtividade("Estudar OO", "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.", cpf1);

        tarefa1 = facade.cadastrarTarefa(atividade1, "Preparar material de estudo", new String[]{"OO"});
    }

}