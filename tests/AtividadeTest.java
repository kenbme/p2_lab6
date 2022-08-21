import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AtividadeTest extends BaseTest {

	String parametroNulo = "Era esperado um erro ao tentar passar um parametro nulo";
	String parametroVazio = "Era esperado um erro ao tentar passar um parametro vazio";
	String parametroInexistente = "Era esperado um erro ao tentar passar um parametro inexistente";
	String naoECPF = "Era esperado um erro ao tentar passar algo que não seja CPF";
	
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
            Assertions.fail(naoECPF);
        } catch (NoSuchElementException nsee) {}
        try {
        	facade.cadastrarAtividade("Estudar OO", descricao, null);
        	Assertions.fail(parametroNulo + " - CPF");
        } catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade("", descricao, cpf1);
        	Assertions.fail(parametroVazio + " - Nome");
        } catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade(null, descricao, cpf1);
        	Assertions.fail(parametroNulo + " - Nome");
        } catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade("Estudar OO", null, cpf1);
        	Assertions.fail(parametroNulo + " - Descrição");
        }catch (IllegalArgumentException iae) {}
        try {
        	facade.cadastrarAtividade("Estudar OO", "", cpf1);
        	Assertions.fail(parametroVazio + " - Descrição");
        } catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void exibirAtividadeErros() {
    	try {
    		facade.exibirAtividade("nada");
        	Assertions.fail(parametroInexistente + " - ID");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.exibirAtividade("");
        	Assertions.fail(parametroVazio + " - ID");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.exibirAtividade(null);
        	Assertions.fail(parametroNulo + " - ID");
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
    		facade.encerrarAtividade("nome Engraçado");
    		Assertions.fail(parametroInexistente + " - ID");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.encerrarAtividade("");
    		Assertions.fail(parametroVazio + " - ID");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.encerrarAtividade(null);
    		Assertions.fail(parametroNulo + " - ID");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void desativarAtividadeStringsInvalidas() {
    	try {
    		facade.desativarAtividade("Dart Vader");
    		Assertions.fail(parametroInexistente + " - ID");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.desativarAtividade("");
    		Assertions.fail(parametroVazio + " - ID");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.desativarAtividade(null);
    		Assertions.fail(parametroNulo + " - ID");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void reabrirAtividadeStringsInvalidas() {
    	String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
    	String atividadeID = facade.cadastrarAtividade("Estudar OO", descricao, cpf1);
    	facade.encerrarAtividade(atividadeID);
    	try {
    		facade.reabrirAtividade("Um ID muito doido");
    		Assertions.fail(parametroInexistente + " - ID");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.reabrirAtividade("");
    		Assertions.fail(parametroVazio + " - ID");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.reabrirAtividade(null);
    		Assertions.fail(parametroNulo + " - ID");
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
    		Assertions.fail(parametroNulo + " - Descrição");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.alterarDescricaoAtividade("github me deu stress", descricao2);
    		Assertions.fail(parametroInexistente + " - ID");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.alterarDescricaoAtividade("", descricao2);
    		Assertions.fail(parametroVazio + " - ID");
    	} catch (IllegalArgumentException iae) {}
    }
    
    @Test
    void alteraResposavelStringsInvalidas() {
    	String descricao = "Atividade de estudo de OO, considerando alunos com experiência de programação e uso da linguagem Java.";
    	String atividadeID = facade.cadastrarAtividade("Estudar OO", descricao, cpf1);
    	try {
    		facade.alterarResponsavelAtividade(atividadeID, "Não é um CPF");
    		Assertions.fail(naoECPF);
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.alterarResponsavelAtividade(atividadeID, "130.199.199.130-19");
    		Assertions.fail(parametroInexistente + " - CPF");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.alterarResponsavelAtividade(atividadeID, null);
    		Assertions.fail(parametroNulo + " - CPF");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.alterarResponsavelAtividade(atividadeID, "");
    		Assertions.fail(parametroVazio + " - CPF");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.alterarResponsavelAtividade("Não é um ID", cpf4);
    		Assertions.fail(parametroInexistente + " - ID");
    	} catch (NoSuchElementException nsee) {}
    	try {
    		facade.alterarResponsavelAtividade("", cpf4);
    		Assertions.fail(parametroVazio + " - ID");
    	} catch (IllegalArgumentException iae) {}
    	try {
    		facade.alterarResponsavelAtividade(null, cpf4);
    		Assertions.fail(parametroNulo + " - ID");
    	} catch (IllegalArgumentException iae) {}
    }
}
