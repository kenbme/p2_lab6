import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtividadeTest extends BaseTest {

    @Test
    void cadastrarAtividadeTest1() {
        String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
        Assertions.assertEquals("STD-1", facade.cadastrarAtividade("Estudar OO", descricao, cpf1));
    }
    
    @Test
    void cadastrarAtividadeStringsInvalidas() {
    	String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
    	try {
            facade.cadastrarAtividade("Estudar OO", descricao, "CPF Errado");	
            Assertions.fail("Era esperado um erro por causa do CPF errado.");
        } catch (NoSuchElementException nsee) {}
        try {
        	facade.cadastrarAtividade("Estudar OO", descricao, null);
        	Assertions.fail("Era esperado um erro por causa do CPF nulo.");
        } catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade("", descricao, cpf1);
        	Assertions.fail("Era esperado um erro por causa do nome vazio");
        } catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade(null, descricao, cpf1);
        	Assertions.fail("Era esperado um erro por causa do nome nulo.");
        } catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade("Estudar OO", null, cpf1);
        	Assertions.fail("Era esperado um erro por causa da descrição nula.");
        }catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade("Estudar OO", "", cpf1);
        	Assertions.fail("Era esperado um erro por causa da descrição vazia.");
        } catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void exibirAtividadeErros() {
    	try {
    		facade.exibirAtividade("nada");
        	Assertions.fail("Era esperado um erro por causa do ID de atividade inexistente.");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.exibirAtividade("");
        	Assertions.fail("Era esperado um erro por causa do ID de atividade vazio.");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.exibirAtividade(null);
        	Assertions.fail("Era esperado um erro por causa do ID de atividade nulo.");
    	} catch (IllegalArgumentException iae) {}
    }

    @Test
    void cadastrarTarefaTest1() {
        String idAtividade = facade.cadastrarAtividade("nome", "descricao", cpf1);
        facade.cadastrarTarefa(idAtividade, "nomeTarefa", new String[]{"habilidade1"});
        Assertions.assertEquals(
                		"NMX-1: nome\n" +
                        "Responsável: Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "descricao\n" +
                        "===\n" +
                        "Tarefas: 0/1\n" +
                        "- nomeTarefa - NMX-1-1"
                ,
                facade.exibirAtividade(idAtividade)
        );
    }

    @Test
    void concluirTarefaTest1() {
        String idAtividade = facade.cadastrarAtividade("nome", "descricao", cpf1);
        String idTarefa = facade.cadastrarTarefa(idAtividade, "nomeTarefa", new String[]{"habilidade1"});
        facade.concluirTarefa(idTarefa);
        Assertions.assertEquals(
                "NMX-1: nome\n" +
                        "Responsável: Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "descricao\n" +
                        "===\n" +
                        "Tarefas: 1/1"
                ,
                facade.exibirAtividade(idAtividade)
        );
    }

    @Test
    void removerTarefaTest1() {
        String idAtividade = facade.cadastrarAtividade("nome", "descricao", cpf1);
        String idTarefa = facade.cadastrarTarefa(idAtividade, "nomeTarefa", new String[]{"habilidade1"});
        facade.removerTarefa(idTarefa);
        Assertions.assertEquals(
                "NMX-1: nome\n" +
                        "Responsável: Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "descricao\n" +
                        "===\n" +
                        "Tarefas: 0/1"
                ,
                facade.exibirAtividade(idAtividade)
        );
    }

    @Test
    void exibirAtividadeComTresTarefasTest() {
        String idAtividade = facade.cadastrarAtividade("nome", "descricao", cpf1);
        facade.cadastrarTarefa(idAtividade, "nomeTarefa1", new String[]{"habilidade1"});
        facade.cadastrarTarefa(idAtividade, "nomeTarefa2", new String[]{"habilidade1"});
        facade.cadastrarTarefa(idAtividade, "nomeTarefa3", new String[]{"habilidade1"});
        Assertions.assertEquals(
                "NMX-1: nome\n" +
                        "Responsável: Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "descricao\n" +
                        "===\n" +
                        "Tarefas: 0/3\n" +
                        "- nomeTarefa3 - NMX-1-3\n" +
                        "- nomeTarefa2 - NMX-1-2\n" +
                        "- nomeTarefa1 - NMX-1-1"
                ,
                facade.exibirAtividade(idAtividade)
        );
    }

    @Test
    void exibirAtividadeComTresTarefasTest2() {
        String idAtividade = facade.cadastrarAtividade("nome", "descricao", cpf1);
        facade.cadastrarTarefa(idAtividade, "nomeTarefa1", new String[]{"habilidade1"});
        String idTarefa2 = facade.cadastrarTarefa(idAtividade, "nomeTarefa2", new String[]{"habilidade1"});
        facade.cadastrarTarefa(idAtividade, "nomeTarefa3", new String[]{"habilidade1"});
        facade.cadastrarTarefa(idAtividade, "nomeTarefa4", new String[]{"habilidade1"});
        facade.removerTarefa(idTarefa2);
        Assertions.assertEquals(
                "NMX-1: nome\n" +
                        "Responsável: Matheus Canella – 222.222.222-22\n" +
                        "===\n" +
                        "descricao\n" +
                        "===\n" +
                        "Tarefas: 0/4\n" +
                        "- nomeTarefa4 - NMX-1-4\n" +
                        "- nomeTarefa3 - NMX-1-3\n" +
                        "- nomeTarefa1 - NMX-1-1"
                ,
                facade.exibirAtividade(idAtividade)
        );
    }
    
    @Test
    void encerrarAtividadeStringsInvalidas() {
    	try {
    		facade.encerrarAtividade("nome Engraçado '-' ");
    		Assertions.fail("Era esperado um erro ao tentar passar um ID inexistente");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.encerrarAtividade("");
    		Assertions.fail("Era esperado um erro ao tentar passar um ID vazio");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.encerrarAtividade(null);
    		Assertions.fail("Era esperado um erro ao tentar passar um ID nulo");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void desativarAtividadeStringsInvalidas() {
    	try {
    		facade.desativarAtividade("Dart Vader");
    		Assertions.fail("Era esperado um erro ao tentar passar um ID inexistente");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.desativarAtividade("");
    		Assertions.fail("Era esperado um erro ao tentar passar um ID vazio");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.desativarAtividade(null);
    		Assertions.fail("Era esperado um erro ao tentar passar um ID nulo");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void reabrirAtividadeStringsInvalidas() {
    	String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
    	String atividadeID = facade.cadastrarAtividade("Estudar OO", descricao, cpf1);
    	facade.encerrarAtividade(atividadeID);
    	try {
    		facade.reabrirAtividade("Um ID muito doido");
    		Assertions.fail("Era esperado um erro ao tentar passar um ID inexistente");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.reabrirAtividade("");
    		Assertions.fail("Era esperado um erro ao tentar passar um ID vazio");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.reabrirAtividade(null);
    		Assertions.fail("Era esperado um erro ao tentar passar um ID nulo");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void atividadeReabrirDesativarEncerrar() {
    	String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
    	String atividadeID = facade.cadastrarAtividade("Estudar OO", descricao, cpf1);
    	String tarefaID = facade.cadastrarTarefa(atividadeID, "nomeTarefa", new String[]{"habilidade1"});
    	try {
    		facade.desativarAtividade(atividadeID);
    		Assertions.fail("Era esperado um erro ao tentar desativar uma atividade com tarefas pendentes.");
    	} catch (IllegalStateException iae) {}
    	try {
    		facade.encerrarAtividade(atividadeID);
    		Assertions.fail("Era esperado um erro ao tentar encerrar uma atividade com tarefas pendentes.");
    	} catch (IllegalStateException ise) {}
    	facade.concluirTarefa(tarefaID);
    	facade.desativarAtividade(atividadeID);
    	try {
    		facade.encerrarAtividade(atividadeID);
    		Assertions.fail("Era esperado um erro ao tentar encerrar uma atividade desativada.");
    	} catch (IllegalStateException ise) {}
    	facade.reabrirAtividade(atividadeID);
    	facade.encerrarAtividade(atividadeID);
    	try {
    		facade.desativarAtividade(atividadeID);
    		Assertions.fail("Era esperado um erro ao tentar desativar uma atividade encerrada.");
    	} catch (IllegalStateException ise) {}
    }
    
    @Test
    void alteraDescricaoStringsInvalidas() {
    	String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
    	String descricao2 = "Descrição alterada.";
    	String atividadeID = facade.cadastrarAtividade("Estudar OO", descricao, cpf1);
    	facade.alterarDescricaoAtividade(atividadeID, descricao2);
    	try {
    		facade.alterarDescricaoAtividade(atividadeID, null);
    	} catch (IllegalArgumentException iae) {}
    }
}
