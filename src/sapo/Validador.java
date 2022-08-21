package sapo;

import java.util.NoSuchElementException;

public class Validador {

    public void valida(String string) throws IllegalArgumentException {
        if (string == null) {
            throw new IllegalArgumentException("String nula.");
        }
        if (string.isBlank()) {
            throw new IllegalArgumentException("String em branco.");
        }
    }

    public void valida(String[] strings) throws IllegalArgumentException {
        if (strings == null) {
            throw new IllegalArgumentException("Lista nula.");
        }
        for (String string : strings) {
            if (string == null) {
                throw new IllegalArgumentException("Lista possui um elemento nulo.");
            }
            if (string.isBlank()) {
                throw new IllegalArgumentException("Lista possui um elemento em branco.");
            }
        }
    }
    
    public void isPositivo(int inteiro) {
    	if (inteiro < 0) {
    		throw new IllegalArgumentException("O valor da hora não pode ser negativo.");
    	}
    }

    public boolean isInteger(char caractere) {
        try {
            Integer.parseInt(String.valueOf(caractere));
            return true;
        }
        catch (NumberFormatException exception) {
            return false;
        }
    }

    public void validaCpf(String cpf) {
        valida(cpf);
        char[] cpfValido = "222.222.222-22".toCharArray();
        if (cpf.length() != cpfValido.length) {
            throw new NoSuchElementException("Formatação do CPF inválida");
        }
        char[] cpfSplitado = cpf.toCharArray();
        for (int i = 0; i < cpfSplitado.length; i++) {
            if (isInteger(cpfValido[i])) {
                if (!isInteger(cpfSplitado[i])) {
                    throw new NoSuchElementException("Formatação do CPF inválida");
                }
            }
            else if (cpfSplitado[i] != cpfValido[i]) {
                throw new NoSuchElementException("Formatação do CPF inválida");
            }
        }
    }
}
