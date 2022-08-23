import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.NoSuchElementException;

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
	void buscaAtividadeTest1() {
		Assertions.assertEquals(Arrays.toString(new String[]{
			"STD-0: Estudar OO\n" +
					"Responsável: Matheus Canella – 222.222.222-22\n" +
					"===\n" +
					"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
					"===\n" +
					"Tarefas: 0/1\n" +
					"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("Estudar")));
	}

	@Test
	void buscaAtividadeTest2() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("estudar")));
	}

	@Test
	void buscaAtividadeTest3() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("Estudo DE OO")));
	}

	@Test
	void buscaAtividadeTest4() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("estudo de OO")));
	}

	@Test
	void buscaAtividadeTest5() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("STD-0")));
	}

	@Test
	void buscaAtividadeTest6() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("std-0")));
	}

	@Test
	void buscaAtividadeTest7() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("std")));
	}

	@Test
	void buscaAtividadeTest8() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("0")));
	}

	@Test
	void buscaAtividadeTest9() {
		Assertions.assertEquals(Arrays.toString(new String[]{
				"STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"
		}), Arrays.toString(facade.buscarAtividade("0 estudo Estudar")));
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
		Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.exibirPessoas(null));
		Assertions.assertEquals(Arrays.toString(new String[]{}), Arrays.toString(facade.exibirPessoas("ConsultaNãoExiste")));
    }
    
    @Test
    void buscarAtividadesStringsInvalidas() {
		Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.buscarAtividade(null));
		Assertions.assertEquals(Arrays.toString(new String[]{}), Arrays.toString(facade.buscarAtividade("IDNãoExiste")));
    }
    
    @Test
    void buscarTarefasStringsInvalidas() {
		Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.buscarTarefas(null));
		Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.buscarTarefas(null, nome1));
		Assertions.assertThrowsExactly(IllegalArgumentException.class, () -> facade.buscarTarefas(atividade1, null));

		Assertions.assertEquals(Arrays.toString(new String[]{}), Arrays.toString(facade.buscarTarefas("NãoTemNiguém")));
		Assertions.assertThrowsExactly(NoSuchElementException.class, () -> facade.buscarTarefas("IDNãoExiste", nome1));
	}

	@Test
	void buscarTarefas1() {
		facade.cadastrarTarefa(atividade1, "Jogar minecraft", new String[]{"gamer"});
		Assertions.assertEquals(Arrays.toString(new String[]{"Jogar minecraft - STD-0-1\n" +
				"- Estudar OO\n" +
				"gamer\n" +
				"(0 hora(s) executada(s))\n" +
				"===\n" +
				"Equipe:"}), Arrays.toString(facade.buscarTarefas("jogar")));
	}

	@Test
	void buscarTarefas2() {
		facade.cadastrarTarefa(atividade1, "Jogar minecraft", new String[]{"gamer"});
		facade.cadastrarTarefa(atividade1, "Construir uma casa no minecraft", new String[]{"gamer"});
		Assertions.assertEquals(Arrays.toString(new String[]{
				"Construir uma casa no minecraft - STD-0-2\n" +
				"- Estudar OO\n" +
				"gamer\n" +
				"(0 hora(s) executada(s))\n" +
				"===\n" +
				"Equipe:, Jogar minecraft - STD-0-1\n" +
				"- Estudar OO\n" +
				"gamer\n" +
				"(0 hora(s) executada(s))\n" +
				"===\n" +
				"Equipe:"}), Arrays.toString(facade.buscarTarefas("Minecraft")));
	}

	@Test
	void buscarTarefasID1() {
		String atividade2 = facade.cadastrarAtividade("Qualquer nome", "descricao", cpf2);
		facade.cadastrarTarefa(atividade1, "Jogar Diablo", new String[]{"gamer"});
		facade.cadastrarTarefa(atividade2, "Jogar minecraft", new String[]{"gamer"});
		facade.cadastrarTarefa(atividade2, "Construir uma casa no minecraft", new String[]{"gamer"});
		Assertions.assertEquals(Arrays.toString(new String[]{
						"Construir uma casa no minecraft - QLQ-1-3\n" +
						"- Qualquer nome\n" +
						"gamer\n" +
						"(0 hora(s) executada(s))\n" +
						"===\n" +
						"Equipe:, Jogar minecraft - QLQ-1-2\n" +
						"- Qualquer nome\n" +
						"gamer\n" +
						"(0 hora(s) executada(s))\n" +
						"===\n" +
						"Equipe:"}),
				Arrays.toString(facade.buscarTarefas(atividade2, "Minecraft")));
	}

	@Test
	void exibirHistoricoBusca1() {
		facade.buscarAtividade("estudar");
		facade.buscarTarefas("estudar");
		Assertions.assertEquals(Arrays.toString(new String[]{"TAREFA"}),
				Arrays.toString(facade.exibirHistoricoBusca(0)));
		Assertions.assertEquals(Arrays.toString(new String[]{"" +
						"ATIVIDADE, STD-0: Estudar OO\n" +
						"Responsável: Matheus Canella – 222.222.222-22\n" +
						"===\n" +
						"Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.\n" +
						"===\n" +
						"Tarefas: 0/1\n" +
						"- Preparar material de estudo - STD-0-0"}),
				Arrays.toString(facade.exibirHistoricoBusca(1)));
	}

}
