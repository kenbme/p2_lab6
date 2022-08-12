import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class PessoaTest extends BaseTest {

    @Test
    void cadastrarPessoaTest() {
        facade.cadastrarPessoa("111.111.111-11", "Matheus Gaudencio do Rêgo", new String[]{"Desenvolvimento web", "Professor", "Programador"});
        Assertions.assertEquals("Matheus Gaudencio do Rêgo – 111.111.111-11\n- Desenvolvimento web\n- Professor\n- Programador"  ,facade.exibirPessoa("111.111.111-11"));
    }

    @Test
    void cadastrarPessoaTest2() {
        facade.cadastrarPessoa("111.111.111-11", "Matheus Gaudencio do Rêgo", new String[]{""});
        Assertions.assertEquals("Matheus Gaudencio do Rêgo – 111.111.111-11\n- "  ,facade.exibirPessoa("111.111.111-11"));
    }

    @Test
    void cadastrarPessoaTest3() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarPessoa("111.111.111-11", "Matheus Gaudencio do Rêgo", null));
    }

    @Test
    void cadastrarPessoaTest4() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarPessoa("", "Matheus Gaudencio do Rêgo", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest5() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarPessoa(" ", "Matheus Gaudencio do Rêgo", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest6() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarPessoa(null, "Matheus Gaudencio do Rêgo", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest7() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarPessoa("111.111.111-11", "", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest8() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarPessoa("111.111.111-11", " ", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest9() {
        Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.cadastrarPessoa("111.111.111-11", null, new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest10() {
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.cadastrarPessoa("111-111-111-11", "Matheus Gaudencio do Rêgo", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest11() {
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.cadastrarPessoa("111.111.111.11", "Matheus Gaudencio do Rêgo", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest12() {
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.cadastrarPessoa("11-.1-1.1-1-11", "Matheus Gaudencio do Rêgo", new String[]{"Desenvolvimento web", "Professor", "Programador"}));
    }

    @Test
    void cadastrarPessoaTest13() {
        Assertions.assertThrowsExactly(IllegalStateException.class, () -> facade.cadastrarPessoa(cpf1, nome1, habilidades1));
    }

    @Test
    void alterarNomePessoaTest() {
        facade.alterarNomePessoa(cpf1, "Mauricio Quadrado");
        Assertions.assertEquals("Mauricio Quadrado – 222.222.222-22\n- Quack", facade.exibirPessoa(cpf1));
    }

    @Test
    void alterarHabilidadesPessoaTest() {
        facade.alterarHabilidadesPessoa(cpf1, new String[]{"Jogar bola"});
        Assertions.assertEquals("Matheus Canella – 222.222.222-22\n- Jogar bola\n- Quack", facade.exibirPessoa(cpf1));
    }

    @Test
    void removerPessoaTest() {
        facade.removerPessoa(cpf1);
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.exibirPessoa(cpf1));
    }

    @Test
    void adicionarComentarioPessoaTest() {
        facade.adicionarComentarioPessoa(cpf1, "Doido de pedra", "333.333.333-33");
        Assertions.assertEquals("Matheus Canella – 222.222.222-22\nComentários:\n-- Doido de pedra (Zé Produções)",
                facade.listarComentariosPessoa(cpf1));
    }

    @Test
    void validaCpfFormatacaoInvalidaTest1() {
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.cadastrarPessoa("222", "Zezin", new String[]{"Chorar"}));
    }

    @Test
    void validaCpfFormatacaoInvalidaTest2() {
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.cadastrarPessoa("222-222-222-22", "Zezin", new String[]{"Chorar"}));
    }

    @Test
    void validaCpfFormatacaoInvalidaTest3() {
        Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.cadastrarPessoa("222.aaa.222-22", "Zezin", new String[]{"Chorar"}));
    }

    @Test
    void exibirPessoa() {
        Assertions.assertEquals("João Veríssimo – 444.444.444-44\n- atendente\n- jogador" , facade.exibirPessoa(cpf3));
    }

}
